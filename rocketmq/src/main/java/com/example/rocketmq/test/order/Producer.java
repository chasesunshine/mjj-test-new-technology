package com.example.rocketmq.test.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

public class Producer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置NameServer的地址  换一个服务器吧
        producer.setNamesrvAddr("192.168.146.130:9876;192.168.146.132:9876");
        // 启动Producer实例
        producer.start();

        // 订单列表
        List<OrderStep> orderList = OrderStep.buildOrders();
        for (int i = 0 ; i < orderList.size() ; i++) {
            String body = orderList.get(i) +"";
            Message msg = new Message("OrderTopic", "Order", "i" + i, body.getBytes());

            // 参数一 ： 消息对象
            // 参数二 ： 消息队列选择器
            // 参数三 ： 选择队列的业务标识（订单ID）
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                /**
                 *
                 * @param mqs : 队列集合
                 * @param msg ： 消息对象
                 * @param arg ：业务标识参数
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    //根据订单id选择发送queue (保证A订单的四个业务都是一个mq)
                    Long id = (Long) arg;
                    long index = id % mqs.size();
                    return mqs.get((int) index);
                }
            }, orderList.get(i).getOrderId());//订单id

            System.out.println("发送结果 ： "+ sendResult);
        }

        producer.shutdown();
    }
}
