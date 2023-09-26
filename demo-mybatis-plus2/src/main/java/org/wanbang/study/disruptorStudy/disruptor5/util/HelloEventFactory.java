package org.wanbang.study.disruptorStudy.disruptor5.util;

import com.lmax.disruptor.EventFactory;

public class HelloEventFactory implements EventFactory<HelloEvent>{

    @Override
    public HelloEvent newInstance() {
        return new HelloEvent();
    }

}