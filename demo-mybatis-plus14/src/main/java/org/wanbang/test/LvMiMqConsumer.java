package org.wanbang.test;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author PB085656
 * @date 2024/10/31
 * @Version 1.0
 * @Description TODO
 */
public class LvMiMqConsumer {


    private final String mqAddress = "3rd-subscription.aqara.cn:9876";
    private final String appId = "12979313793780776965bd52";
    private final String keyId = "K.1297931379814285312";
    private final String appKey = "lys0sb2ps4xkgnhiuz9w3soz96x85hld";

    public static void main(String[] args) {
        LvMiMqConsumer mqConsumer = new LvMiMqConsumer();

        try {
            mqConsumer.start();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws MQClientException {

        AclClientRPCHook acl = new AclClientRPCHook(new SessionCredentials(keyId, appKey));
        //设置消费者组
        // public DefaultMQPushConsumer(String consumerGroup, RPCHook rpcHook, AllocateMessageQueueStrategy allocateMessageQueueStrategy)
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(appId, acl, new AllocateMessageQueueAveragely());

        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr(mqAddress);
        //设置消费者端消息拉取策略，表示从哪里开始消费
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(
//                System.currentTimeMillis() - (1000 * 10 * 1)));

        //设置从10分钟前开始消费，配合setConsumeTimestamp一起使用,格式yyyyMMddhhmmss
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis() - 1000 * 60 * 10));

        //设置消费者拉取消息的策略，*表示消费该topic下的所有消息，也可以指定tag进行消息过滤
        consumer.subscribe(appId, "*");

        //消费者端启动消息监听，一旦生产者发送消息被监听到，就打印消息，和rabbitmq中的handlerDelivery类似
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                try {
                    for (MessageExt messageExt : msgs) {
                        String topic = messageExt.getTopic();
                        String tag = messageExt.getTags();
                        String msg = new String(messageExt.getBody());

                        System.out.println(convertUTCToBeijingTime(convertTimestampToUTC(System.currentTimeMillis())));

                        System.out.println("topic: "+topic+"  ******device info******{}" + msg);

                        //log.info("******device info******{}", msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //调用start()方法启动consumer
        consumer.start();
    }


    // 将时间戳转换为UTC时间字符串
    public String convertTimestampToUTC(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.of("UTC"))
                .format(instant);
    }

    // 将UTC时间字符串转换为中国北京东八区时间字符串
    public String convertUTCToBeijingTime(String utcTime) {
        // 将UTC时间字符串转换为Instant
        Instant instant = Instant.parse(utcTime.replace(" ", "T") + "Z"); // 替换空格为T并添加Z
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.of("Asia/Shanghai")) // 北京时区
                .format(instant);
    }

}
