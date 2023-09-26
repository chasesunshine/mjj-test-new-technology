package org.wanbang.study.disruptorStudy.disruptor4.consumer;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import org.wanbang.study.disruptorStudy.disruptor4.util.LongEvent;

/**
 * 该消费者类执行将数值乘以10的操作
 */
public class C12EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        long number = event.getNumber();
        number *= 10;
        System.out.println(System.currentTimeMillis()+": c1-2 consumer finished.number=" + number);
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        long number = event.getNumber();
        number *= 10;
        System.out.println(System.currentTimeMillis()+": c1-2 consumer finished.number=" + number);
    }
}
