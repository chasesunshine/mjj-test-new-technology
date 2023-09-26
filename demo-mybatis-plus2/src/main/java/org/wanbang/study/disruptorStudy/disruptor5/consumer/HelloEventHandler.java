package org.wanbang.study.disruptorStudy.disruptor5.consumer;

import com.lmax.disruptor.EventHandler;
import org.wanbang.study.disruptorStudy.disruptor5.util.HelloEvent;

public class HelloEventHandler implements EventHandler<HelloEvent>{

    @Override
    public void onEvent(HelloEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("HelloEventHandler: "+event.getValue());
    }

}
