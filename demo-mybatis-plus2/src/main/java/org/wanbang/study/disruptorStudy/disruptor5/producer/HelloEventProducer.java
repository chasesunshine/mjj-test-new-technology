package org.wanbang.study.disruptorStudy.disruptor5.producer;

import com.lmax.disruptor.RingBuffer;
import org.wanbang.study.disruptorStudy.disruptor5.util.HelloEvent;

public class HelloEventProducer implements Runnable {
    private final RingBuffer<HelloEvent> ringBuffer;

    public HelloEventProducer(RingBuffer<HelloEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件
     * 它的参数会用过事件传递给消费者
     */
    public void onData(String str) {
        long sequence = ringBuffer.next();
        System.out.println("sequence: "+sequence);
        try {
            HelloEvent event = ringBuffer.get(sequence);

            event.setValue(str);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

    @Override
    public void run() {
        for (long l = 0; l < 100; l++) {
            this.onData("mjj：Hello World！！！:" + l);
        }
    }
}