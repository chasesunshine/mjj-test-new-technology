package com.example.rocketmq.test.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class ConsumerInOrder {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者,指定组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        // 指定Namesrv地址信息.
        consumer.setNamesrvAddr("192.168.146.130:9876;192.168.146.132:9876");
        // 订阅Topic
        consumer.subscribe("OrderTopic", "*");
        // 负载均衡模式消费
        consumer.setMessageModel(MessageModel.CLUSTERING);

        // 注册消息监听 MessageListenerOrderly - 按照顺序消费
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext consumeOrderlyContext) {

                for (MessageExt msg:msgs) {
                    System.out.println("线程名称 ："+Thread.currentThread().getName() +" - "+new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();

        System.out.println("Consumer Started.");
    }
}