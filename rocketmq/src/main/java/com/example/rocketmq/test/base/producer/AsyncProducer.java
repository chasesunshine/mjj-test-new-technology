package com.example.rocketmq.test.base.producer;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.146.130:9876;192.168.146.132:9876");
        // 启动Producer实例
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("Base","Tag2", ("Hello world"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            // SendCallback接收异步返回结果的回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送成功: "+ JSON.toJSONString(sendResult));
                }
                @Override
                public void onException(Throwable e) {
                    System.out.println("发送失败: "+ JSON.toJSONString(e));
                    e.printStackTrace();
                }
            });

            TimeUnit.SECONDS.sleep(2);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
