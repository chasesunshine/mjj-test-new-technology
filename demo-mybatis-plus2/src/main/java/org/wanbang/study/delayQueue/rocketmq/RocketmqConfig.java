package org.wanbang.study.delayQueue.rocketmq;

public class RocketmqConfig {

//    /**
//     * 延时队列
//     */
//    @Bean(name = "order.delay.queue")
//    public Queue getMessageQueue() {
//        return QueueBuilder
//                .durable(RabbitConstant.DEAD_LETTER_QUEUE)
//                // 配置到期后转发的交换
//                .withArgument("x-dead-letter-exchange", "order.close.exchange")
//                // 配置到期后转发的路由键
//                .withArgument("x-dead-letter-routing-key", "order.close.queue")
//                .build();
//    }

}
