# SpringBoot订单支付后消息可靠补偿方案 （deepseek）

在订单支付后的操作中，发送异步消息到积分和短信服务时可能会遇到网络抖动、服务不可用等异常情况。下面提供一个完整的可靠消息补偿方案，包含本地消息表和异步重试机制。

## 方案设计

1. **本地消息表**：在业务数据库中创建消息表，记录需要发送的消息
2. **事务一致性**：将业务操作和消息记录放在同一个事务中
3. **定时任务**：定期扫描未完成的消息进行重试
4. **幂等处理**：消费端需要实现幂等性，防止重复消费

## 完整实现代码

### 1. 数据库表设计

```sql
CREATE TABLE `message_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `message_id` varchar(64) NOT NULL COMMENT '消息唯一ID',
  `topic` varchar(128) NOT NULL COMMENT '消息主题',
  `content` text NOT NULL COMMENT '消息内容',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0-待发送，1-已发送，2-发送失败',
  `retry_count` int NOT NULL DEFAULT '0' COMMENT '重试次数',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `business_key` varchar(64) DEFAULT NULL COMMENT '业务唯一标识',
  `business_type` varchar(32) DEFAULT NULL COMMENT '业务类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_message_id` (`message_id`),
  KEY `idx_status_retry` (`status`,`retry_count`),
  KEY `idx_business` (`business_type`,`business_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息记录表';
```

### 2. 消息记录实体类

```java
@Data
@TableName("message_record")
public class MessageRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String messageId;
    private String topic;
    private String content;
    private Integer status;
    private Integer retryCount;
    private Date createTime;
    private Date updateTime;
    private String businessKey;
    private String businessType;

    public static final int STATUS_PENDING = 0;
    public static final int STATUS_SENT = 1;
    public static final int STATUS_FAILED = 2;
}
```

### 3. 消息记录Mapper

```java
public interface MessageRecordMapper extends BaseMapper<MessageRecord> {

    @Select("SELECT * FROM message_record WHERE status = 0 AND retry_count < #{maxRetryCount} ORDER BY create_time ASC LIMIT #{limit}")
    List<MessageRecord> selectPendingMessages(@Param("maxRetryCount") int maxRetryCount, @Param("limit") int limit);

    @Update("UPDATE message_record SET status = #{status}, retry_count = retry_count + 1, update_time = NOW() WHERE message_id = #{messageId}")
    int updateMessageStatus(@Param("messageId") String messageId, @Param("status") int status);
}
```

### 4. 消息发送服务

```java
@Service
@Slf4j
public class ReliableMessageService {

    @Autowired
    private MessageRecordMapper messageRecordMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate; // 或RabbitTemplate等

    @Value("${message.max.retry.count:5}")
    private int maxRetryCount;

    @Transactional(rollbackFor = Exception.class)
    public void saveAndSendMessage(String topic, String content, String businessKey, String businessType) {
        // 生成唯一消息ID
        String messageId = UUID.randomUUID().toString();

        // 保存消息到本地表
        MessageRecord record = new MessageRecord();
        record.setMessageId(messageId);
        record.setTopic(topic);
        record.setContent(content);
        record.setStatus(MessageRecord.STATUS_PENDING);
        record.setBusinessKey(businessKey);
        record.setBusinessType(businessType);
        messageRecordMapper.insert(record);

        // 尝试立即发送
        try {
            sendMessage(record);
        } catch (Exception e) {
            log.warn("首次发送消息失败，将加入重试队列", e);
        }
    }

    public void sendMessage(MessageRecord record) {
        try {
            // 实际发送消息到MQ
            kafkaTemplate.send(record.getTopic(), record.getContent()).get();

            // 更新状态为已发送
            messageRecordMapper.updateMessageStatus(record.getMessageId(), MessageRecord.STATUS_SENT);
            log.info("消息发送成功，messageId: {}", record.getMessageId());
        } catch (Exception e) {
            log.error("消息发送失败，messageId: {}", record.getMessageId(), e);

            // 更新状态为失败
            messageRecordMapper.updateMessageStatus(record.getMessageId(), MessageRecord.STATUS_FAILED);

            // 如果超过最大重试次数，可以记录日志或告警
            if (record.getRetryCount() + 1 >= maxRetryCount) {
                log.error("消息已达到最大重试次数，放弃发送，messageId: {}", record.getMessageId());
                // 这里可以添加告警逻辑
            }
        }
    }
}
```

### 5. 订单支付服务

```java
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ReliableMessageService reliableMessageService;

    @Transactional(rollbackFor = Exception.class)
    public void handlePaySuccess(Long orderId) {
        // 1. 更新订单状态为已支付
        Order order = orderMapper.selectById(orderId);
        order.setStatus(OrderStatus.PAID.getCode());
        order.setPayTime(new Date());
        orderMapper.updateById(order);

        // 2. 发送积分消息（本地事务保证）
        String pointsMessage = buildPointsMessage(order);
        reliableMessageService.saveAndSendMessage("topic.points", pointsMessage,
                String.valueOf(orderId), "order");

        // 3. 发送短信消息（本地事务保证）
        String smsMessage = buildSmsMessage(order);
        reliableMessageService.saveAndSendMessage("topic.sms", smsMessage,
                String.valueOf(orderId), "order");
    }

    private String buildPointsMessage(Order order) {
        Map<String, Object> content = new HashMap<>();
        content.put("userId", order.getUserId());
        content.put("orderId", order.getId());
        content.put("points", order.getAmount().intValue()); // 假设1元=1积分
        return JSON.toJSONString(content);
    }

    private String buildSmsMessage(Order order) {
        Map<String, Object> content = new HashMap<>();
        content.put("phone", order.getUserPhone());
        content.put("templateId", "ORDER_PAY_SUCCESS");
        content.put("params", new String[]{order.getOrderNo(), order.getAmount().toString()});
        return JSON.toJSONString(content);
    }
}
```

### 6. 定时重试任务

```java
@Component
@Slf4j
public class MessageRetryTask {

    @Autowired
    private ReliableMessageService reliableMessageService;

    @Autowired
    private MessageRecordMapper messageRecordMapper;

    @Value("${message.retry.batch.size:100}")
    private int batchSize;

    @Value("${message.max.retry.count:5}")
    private int maxRetryCount;

    @Scheduled(fixedDelay = 60000) // 每分钟执行一次
    public void retryPendingMessages() {
        log.info("开始重试待发送消息...");

        // 查询待发送的消息
        List<MessageRecord> pendingMessages = messageRecordMapper.selectPendingMessages(maxRetryCount, batchSize);

        if (pendingMessages.isEmpty()) {
            log.info("没有待重试的消息");
            return;
        }

        log.info("本次需要重试的消息数量: {}", pendingMessages.size());

        // 遍历并重试发送
        for (MessageRecord message : pendingMessages) {
            try {
                reliableMessageService.sendMessage(message);
            } catch (Exception e) {
                log.error("重试发送消息失败，messageId: {}", message.getMessageId(), e);
            }
        }

        log.info("消息重试任务完成");
    }
}
```

### 7. 消费端幂等处理

```java
@Service
@Slf4j
public class PointsServiceConsumer {

    @Autowired
    private PointsService pointsService;

    @KafkaListener(topics = "topic.points")
    public void consumePointsMessage(String message) {
        log.info("收到积分消息: {}", message);

        try {
            JSONObject json = JSON.parseObject(message);
            String messageId = json.getString("messageId"); // 消息中需要包含唯一ID
            Long userId = json.getLong("userId");
            Long orderId = json.getLong("orderId");
            Integer points = json.getInteger("points");

            // 检查是否已处理过（需要实现幂等存储）
            if (pointsService.isMessageProcessed(messageId)) {
                log.warn("重复消息，已处理过，messageId: {}", messageId);
                return;
            }

            // 处理积分业务
            pointsService.addPoints(userId, points, "订单奖励，订单ID:" + orderId, messageId);

        } catch (Exception e) {
            log.error("处理积分消息异常", e);
            throw e; // 抛出异常让MQ重试
        }
    }
}
```

## 配置项

在application.properties或application.yml中添加配置：

```properties
# 消息重试配置
message.max.retry.count=5
message.retry.batch.size=100
message.retry.interval=60000

# Kafka配置
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.acks=all
spring.kafka.producer.retries=3
```

## 方案优势

1. **可靠性**：通过本地消息表确保消息不会丢失
2. **一致性**：业务操作和消息记录在同一个事务中
3. **可恢复性**：定时任务自动重试失败的消息
4. **可扩展性**：可以轻松添加新的消息类型和消费者
5. **幂等性**：消费端通过唯一ID实现幂等处理

## 注意事项

1. 消息表需要定期归档或清理已成功处理的消息，避免数据量过大
2. 对于非常重要的消息，可以增加人工干预接口
3. 可以增加监控告警，对达到最大重试次数的消息进行人工处理
4. 在高并发场景下，需要考虑消息表的分库分表

这个方案在大多数业务场景下都能提供可靠的消息补偿机制，确保订单支付后的积分和短信服务能够最终一致性地完成。