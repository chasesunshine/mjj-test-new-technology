package org.wanbang.study.disruptorStudy.disruptor3Main;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;
import org.wanbang.study.disruptorStudy.disruptor3Main.event.MessageEvent;
import org.wanbang.study.disruptorStudy.disruptor3Main.factory.MessageEventFactory;
import org.wanbang.study.disruptorStudy.disruptor3Main.factory.MessageThreadFactory;
import org.wanbang.study.disruptorStudy.disruptor3Main.handler.MessageEventHandler;
import org.wanbang.study.disruptorStudy.disruptor3Main.handler.MessageExceptionHandler;

import java.util.concurrent.ThreadFactory;

@Slf4j
public class DisruptorTest {
    /**
     * 消息转换类，负责将消息转换为事件
     */
    public static class MessageEventTranslator implements EventTranslatorOneArg<MessageEvent,String> {
        @Override
        public void translateTo(MessageEvent messageEvent, long l, String s) {
            log.info("消息转换类，负责将消息转换为事件");
            messageEvent.setMessage(s);
        }
    }

    /**
     * 1. 创建 Disruptor 对象（参数）
     *      - 消息事件工厂类        implements EventFactory<T>
     *      - RingBuffer 的大小   传入大小
     *      - 消费者线程工厂类      implements ThreadFactory
     *      - 生产者类型
     *      - 等待策略，3种
     *
     * 2. Disruptor 设置 - 消息事件处理类
     *
     * 3. Disruptor 设置 - 异常处理类
     *
     * 4. 启动 disruptor 返回 RingBuffer对象
     *
     * 5. 获取到 RingBuffer对象 ， 推送事件让 消息事件处理类 处理
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        int ringBufferSize = 8;//必须是2的N次方
        Disruptor<MessageEvent> disruptor = new Disruptor<MessageEvent>(
                new MessageEventFactory(),
                ringBufferSize,
                new MessageThreadFactory(),

                ProducerType.SINGLE,
                new BlockingWaitStrategy());

        // 设置 - 消息事件处理类
        disruptor.handleEventsWith(new MessageEventHandler());
        // 设置 异常处理类
        disruptor.setDefaultExceptionHandler(new MessageExceptionHandler());

        // 启动 disruptor 返回 RingBuffer对象
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();

        ThreadLocalDisruptor.setRingBuffer(ringBuffer);
        // MessageEventProducer producer = new MessageEventProducer(ringBuffer);
//        EventTranslatorOneArg<MessageEvent,String> translator = new MessageEventTranslator();
//        ringBuffer.publishEvent(translator,message);

        // 要在这个线程
        Thread.sleep(2000);
        RingBuffer<MessageEvent> ringBuffer1 = ThreadLocalDisruptor.getRingBuffer();
        EventTranslatorOneArg<MessageEvent,String> translator = new DisruptorTest.MessageEventTranslator();
        ringBuffer1.publishEvent(translator,"Hello Disruptor1!");


        // 要在这个线程
        Thread.sleep(2000);
        RingBuffer<MessageEvent> ringBuffer2 = ThreadLocalDisruptor.getRingBuffer();
        EventTranslatorOneArg<MessageEvent,String> translator2 = new DisruptorTest.MessageEventTranslator();
        ringBuffer2.publishEvent(translator2,"Hello Disruptor2!!!");
    }
}