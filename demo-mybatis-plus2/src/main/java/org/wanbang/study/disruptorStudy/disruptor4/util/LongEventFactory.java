package org.wanbang.study.disruptorStudy.disruptor4.util;

import com.lmax.disruptor.EventFactory;

// 事件工厂类
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
