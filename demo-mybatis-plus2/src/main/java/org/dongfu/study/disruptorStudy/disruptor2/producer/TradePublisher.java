package org.dongfu.study.disruptorStudy.disruptor2.producer;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import org.dongfu.study.disruptorStudy.disruptor2.util.Trade;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class TradePublisher implements Runnable {

    Disruptor<Trade> disruptor;
    private CountDownLatch latch;

    private static int LOOP = 1;    // 模拟百万次交易的发生

    public TradePublisher(CountDownLatch latch, Disruptor<Trade> disruptor) {
        this.disruptor=disruptor;
        this.latch=latch;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeTransloator = new TradeEventTranslator();
        for(int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeTransloator);
        }
        latch.countDown();
    }

}

class TradeEventTranslator implements EventTranslator<Trade>{

    @Override
    public void translateTo(Trade event, long sequence) {
        event.setId(UUID.randomUUID().toString());
    }

}
