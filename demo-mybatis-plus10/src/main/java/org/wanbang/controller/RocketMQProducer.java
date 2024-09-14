package org.wanbang.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.wanbang.dto.MQMessageContentDTO;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;

/**
 * @author ZhangYu
 * @date 2024/1/17
 */
public class RocketMQProducer {

    public static void main(String[] args) throws Exception {
//        extracted();
//        extracted1();
//        extracted2();
        extracted4();
    }

    private static void extracted4() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("IotAdmin", "Daikin@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("iot_device_room_group",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("124.71.159.144:8200");
        // 启动生产者
        producer.start();

        Message msg = new Message("topic_ctc_sync_room", "*", "-------Hello rain-----".getBytes());

        SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                String orderId = (String) arg;
                int index = Math.abs(orderId.hashCode() % mqs.size());
                return mqs.get(index);
            }
        }, 2);
        System.out.printf("%s%n", sendResult);
        producer.shutdown();

    }

    private static void extracted1() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("IotAdmin", "Daikin@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("iot_device_room_group",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("124.71.159.144:8200");
        // 启动生产者
        producer.start();

        try {
            // 创建消息实例，指定主题、标签和消息体
            Message message = new Message("topic_ctc_sync_room", "*", "-------Hello rain-----".getBytes());
            // 发送消息
            SendResult send = producer.send(message, 10000);
            System.out.println("Message sent.");
        } finally {
            // 关闭生产者
            producer.shutdown();
        }
    }

    private static void extracted() throws Exception {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("IotAdmin", "Daikin@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("123",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("124.71.159.144:8200");
        // 启动生产者
        producer.start();

        try {
            String encrypt = Encrypt("-------Hello rain-----", "pms654321;++==--");
            // 创建消息实例，指定主题、标签和消息体
            Message message = new Message("device_data_push", "*", encrypt.getBytes());
            // 发送消息
            System.out.println(encrypt);
            SendResult send = producer.send(message, 10000);
            System.out.println("Message sent successfully.");
        } finally {
            // 关闭生产者
            producer.shutdown();
        }
    }

    private static void extracted2() throws Exception {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("IotAdmin", "Daikin@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("iot_consumer_group",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("124.71.159.144:8200");
        // 启动生产者
        producer.start();

        MQMessageContentDTO mqMessageContentDTO = new MQMessageContentDTO();
        mqMessageContentDTO.setSign("123");


        try {
            String encrypt = Encrypt("-------Hello rain-----", "pms654321;++==--");
            // 创建消息实例，指定主题、标签和消息体
            Message message = new Message("device_data_push", "*", encrypt.getBytes());
            // 发送消息
            System.out.println(encrypt);
            SendResult send = producer.send(message, 10000);
            System.out.println("Message sent successfully.");
        } finally {
            // 关闭生产者
            producer.shutdown();
        }
    }

    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }
}
