package com.example.rocketmq.test.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

 // 发送批量消息
public class Producer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址  换一个服务器吧
        producer.setNamesrvAddr("192.168.146.130:9876;192.168.146.132:9876");
        // 启动Producer实例
        producer.start();


        List<Message> msg = new ArrayList<>();
        String topic = "BatchTopic";
        msg.add(new Message(topic, "TagA", "OrderID001", "Hello world 0".getBytes()));
        msg.add(new Message(topic, "TagA", "OrderID002", "Hello world 1".getBytes()));
        msg.add(new Message(topic, "TagA", "OrderID003", "Hello world 2".getBytes()));


        // 发送消息到一个Broker
        SendResult sendResult = producer.send(msg);
        // 通过sendResult返回消息是否成功送达
        System.out.printf("%s%n", sendResult);

        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
