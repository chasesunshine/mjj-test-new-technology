package org.dongfu.study.disruptorStudy.disruptor1.consumer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import org.dongfu.study.disruptorStudy.disruptor1.util.LongEvent;

import java.nio.ByteBuffer;

//很明显的是：当用一个简单队列来发布事件的时候会牵涉更多的细节，这是因为事件对象还需要预先创建。
// 发布事件最少需要两步：获取下一个事件槽并发布事件（ 发布事件的时候要使用 try/finally 保证事件一定会被发布 ）。
// 如果我们使用 RingBuffer.next() 获取一个事件槽，那么一定要发布对应的事件。
// 如果不能发布事件，那么就会引起 Disruptor 状态的混乱。尤其是在多个事件生产者的情况下会导致事件消费者失速，从而不得不重启应用才能会恢复。
//
//Disruptor 3.0 提供了 lambda 式的 API。这样可以把一些复杂的操作放在 Ring Buffer，
// 所以在 Disruptor3.0 以后的版本最好使用 Event Publisher 或者 Event Translator 来发布事件。
public class LongEventProducerWithTranslator {
    //一个translator可以看做一个事件初始化器，publicEvent方法会调用它
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                public void translateTo(LongEvent event, long sequence, ByteBuffer buffer) {
                    event.setValue(buffer.getLong(0));
                }
            };

    private final RingBuffer<LongEvent> ringBuffer;
    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    public void onData(ByteBuffer buffer) {
        ringBuffer.publishEvent(TRANSLATOR, buffer);
    }
}
