package org.wanbang.study.disruptorStudy.disruptor2.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import org.wanbang.study.disruptorStudy.disruptor2.consumer.Handler1;
import org.wanbang.study.disruptorStudy.disruptor2.consumer.Handler2;
import org.wanbang.study.disruptorStudy.disruptor2.consumer.Handler3;
import org.wanbang.study.disruptorStudy.disruptor2.producer.TradePublisher;
import org.wanbang.study.disruptorStudy.disruptor2.util.Trade;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long beginTime=System.currentTimeMillis();
        int bufferSize=1024;
        ExecutorService executor=Executors.newFixedThreadPool(8);

        Disruptor<Trade> disruptor = new Disruptor<>(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        }, bufferSize, executor, ProducerType.SINGLE, new BusySpinWaitStrategy());

        //菱形操作
        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<Trade> handlerGroup = disruptor.handleEventsWith(new Handler1(), new Handler2());
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(new Handler3());

        disruptor.start();//启动


        CountDownLatch latch=new CountDownLatch(1);
        //生产者准备
        executor.submit(new TradePublisher(latch, disruptor));
        //等待生产者完事.
        latch.await();

        disruptor.shutdown();
        executor.shutdown();
        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime));
    }
}