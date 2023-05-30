package com.example.rocketmq.test.transaction;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

public class Producer {
    public static void main(String[] args) throws Exception {
        //创建消息生产者(事务生产者)
        TransactionMQProducer producer = new TransactionMQProducer("group5");
        // 设置NameServer的地址  换一个服务器吧
        producer.setNamesrvAddr("192.168.146.130:9876;192.168.146.132:9876");

        //生产者 这是监听器（因为是半成功消息  所以 发送到队列后会来监听，并且执行 @Override里面的方法）
        producer.setTransactionListener(new TransactionListener(){

            /**
             * 在该方法中执行本地事务
             * @param msg
             * @param o
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object o) {
                System.out.println("执行本地事务");
                if (StringUtils.equals("TagA", msg.getTags())) {
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (StringUtils.equals("TagB", msg.getTags())) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else {
                    return LocalTransactionState.UNKNOW;
                }
            }

            /**
             * MQ进行消息事务状态回传（状态未知的时候 LocalTransactionState.UNKNOW 调用这个方法）
             * @param msg
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("MQ检查消息Tag【"+msg.getTags()+"】的本地事务执行结果");
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        // 启动Producer实例
        producer.start();

        String[] tags = new String[]{"TagA", "TagB", "TagC"};
        for (int i = 0; i < 3; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("TransactionTopic", tags[i], ("Hello RocketMQ " + i).getBytes());
            // 发送事务消息
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.printf("发送结果 ： ", JSON.toJSONString(sendResult));
            // 线程睡眠一秒
            TimeUnit.SECONDS.sleep(1);
        }
        // 如果不再发送消息，关闭Producer实例。
        //producer.shutdown();
    }
}
