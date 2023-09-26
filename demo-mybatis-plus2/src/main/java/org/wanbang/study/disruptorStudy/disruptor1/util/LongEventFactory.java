package org.wanbang.study.disruptorStudy.disruptor1.util;

import com.lmax.disruptor.EventFactory;

// 由于需要让 Disruptor 为我们创建事件，我们同时还声明了一个 EventFactory 来实例化 Event 对象。
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}