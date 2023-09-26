package org.wanbang.study.disruptorStudy.disruptor4.consumer;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import org.wanbang.study.disruptorStudy.disruptor4.util.LongEvent;

/**
 * 该消费者类负责将数值+20
 */
public class C21EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        long number = event.getNumber();
        number += 20;
        System.out.println(System.currentTimeMillis()+": c2-1 consumer finished.number=" + number);
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        long number = event.getNumber();
        number += 20;
        System.out.println(System.currentTimeMillis()+": c2-1 consumer finished.number=" + number);
    }
}
