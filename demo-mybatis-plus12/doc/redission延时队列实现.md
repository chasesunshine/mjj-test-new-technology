# springboot redission 实现延时队列demo (详见 demo-mybatis-plus12/src/main/java/org/wanbang/controller/TestRedisLock.java )
    import org.springframework.data.redis.core.RedisTemplate;
    import org.springframework.data.redis.core.StringRedisTemplate;
    import org.springframework.scheduling.annotation.Scheduled;
    import org.springframework.stereotype.Component;

    import javax.annotation.Resource;
    import java.util.List;
    import java.util.concurrent.TimeUnit;

    @Component
    public class DelayQueueDemo {

        @Resource
        private StringRedisTemplate redisTemplate;

        // 生产者，将消息放入延时队列
        public void produce(String key, String value, long delaySeconds) {
            long currentTime = System.currentTimeMillis() / 1000L + delaySeconds;
            redisTemplate.opsForZSet().add("delay_queue", value, currentTime);
        }

        // 消费者，从延时队列取出消息并处理
        @Scheduled(fixedRate = 1000)
        public void consume() {
            long currentTime = System.currentTimeMillis() / 1000L;
            Set<String> values = redisTemplate.opsForZSet().rangeByScore("delay_queue", 0, currentTime);
            if (values != null && !values.isEmpty()) {
                for (String value : values) {
                    // 处理业务逻辑
                    System.out.println("处理消息: " + value);
                    // 处理完毕后移除队列中的消息
                    redisTemplate.opsForZSet().remove("delay_queue", value);
                }
            }
        }
    }
这个示例展示了如何使用Redis的zset数据结构来实现一个简单的延时队列。produce方法将消息添加到延时队列中，
并计算出消息需要被处理的准确时间。consume方法使用@Scheduled注解来周期性地检查是否有消息需要被处理，并打印出消息内容。
注意，这个例子没有考虑并发问题，实际应用中需要通过锁等机制来保证消息不会被重复消费。


# 个人描述：
    代买1：
        for (int i = 0; i < 5; i++) {
            long currentTime = System.currentTimeMillis() / 1000L + 1;
            redisTemplate.opsForZSet().add("delay_queue", "测试", currentTime);
        }

          这个地方是模拟多个请求过来，
            zset类型：
                Boolean add(K key, V value, double score);
                   demo: redisTemplate.opsForZSet().add("delay_queue", "测试", currentTime);

                Long add(K key, Set<TypedTuple<V>> tuples);
                    demo:
                        Set<String> set = new TreeSet<>();
                        set.add("dsadsadsa123");
                        set.add("dsadsadsaxxx");
                        redisTemplate.opsForZSet().add("123",set);

            redis中key为 zset类型：
                 数据形式：
                 ZSET: delay_queue
                 row     value    score
                 1       测试      1734167295


    代码2：
        while (true){
            Thread.sleep(1000);
            long currentTime = System.currentTimeMillis() / 1000L;
            Set<String> values = redisTemplate.opsForZSet().rangeByScore("delay_queue", 0, currentTime);
            if (values != null && !values.isEmpty()) {
                for (String value : values) {
                    // 处理业务逻辑
                    System.out.println("处理消息: " + value);

                    // 处理完毕后移除队列中的消息
                    redisTemplate.opsForZSet().remove("delay_queue", value);
                }
            }
        }
    这地方循环处理，每一秒都在遍历
    每一秒内都在处理：
        处理一秒内的数据，然后移除 zset 的 value