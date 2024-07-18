package org.wanbang.controller;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author ZhangYu
 * @date 2024/1/17
 */
public class RocketMQProducer {

    public static void main(String[] args) throws Exception {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("IotAdmin", "Daikin@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("dev-EquipmentHourlyDataQueue-Group",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("124.71.159.144:8200");
        // 启动生产者
        producer.start();

        try {
            // 创建消息实例，指定主题、标签和消息体
            Message message = new Message("device_data_push", "*", "-------Hello rain-----".getBytes());
            // 发送消息
            SendResult send = producer.send(message, 10000);
            System.out.println("Message sent successfully.");
        } finally {
            // 关闭生产者
            producer.shutdown();
        }
    }
}
