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
        extracted();
    }

    private static void extracted() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        AclClientRPCHook auth = new AclClientRPCHook(new SessionCredentials("K.1297931379814285312", "lys0sb2ps4xkgnhiuz9w3soz96x85hld@iot"));
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("your-producer-group",auth);
        // 指定NameServer地址，多个地址用分号分隔
        producer.setNamesrvAddr("3rd-subscription.aqara.cn:9876");
        // 启动生产者
        producer.start();

        Message msg = new Message("12979313793780776965bd52", "*", "-------Hello rain-----".getBytes());

        SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                System.out.println(mqs.size());
                return mqs.get(1);
            }
        }, 2);
        System.out.printf("%s%n", sendResult);
        producer.shutdown();
    }

}
