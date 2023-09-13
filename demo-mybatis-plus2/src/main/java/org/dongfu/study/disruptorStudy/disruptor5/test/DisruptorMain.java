package org.dongfu.study.disruptorStudy.disruptor5.test;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.dongfu.study.disruptorStudy.disruptor5.util.HelloEvent;
import org.dongfu.study.disruptorStudy.disruptor5.util.HelloEventFactory;
import org.dongfu.study.disruptorStudy.disruptor5.consumer.HelloEventHandler;
import org.dongfu.study.disruptorStudy.disruptor5.producer.HelloEventProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorMain {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 三种策略模式
//        WaitStrategy blockingWaitStrategy = new BlockingWaitStrategy();
//        WaitStrategy sleepingWaitStrategy = new SleepingWaitStrategy();
        WaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();

        EventFactory<HelloEvent> eventFactory = new HelloEventFactory();

        int ringBufferSize = 1024 * 1024;

        Disruptor<HelloEvent> disruptor = new Disruptor<HelloEvent>(
                eventFactory,
                ringBufferSize,
                executor,
                ProducerType.SINGLE
                , yieldingWaitStrategy);

        EventHandler<HelloEvent> eventHandler = new HelloEventHandler();

        disruptor.handleEventsWith(eventHandler);

        disruptor.start();

        RingBuffer<HelloEvent> ringBuffer = disruptor.getRingBuffer();

        HelloEventProducer producer = new HelloEventProducer(ringBuffer);

        for(long l = 0; l<100; l++){
            producer.onData("黄育源：Hello World！！！:" + l);
        }
    }
}