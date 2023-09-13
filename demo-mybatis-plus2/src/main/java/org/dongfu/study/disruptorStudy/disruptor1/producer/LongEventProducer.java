package org.dongfu.study.disruptorStudy.disruptor1.producer;

import com.lmax.disruptor.RingBuffer;
import org.dongfu.study.disruptorStudy.disruptor1.util.LongEvent;

import java.nio.ByteBuffer;

// 事件都会有一个生成事件的源，可以简单的理解为一个事件生产者。这个例子中假设事件是由于磁盘IO或者network读取数据的时候触发的，
// 事件源使用一个ByteBuffer来模拟它接受到的数据，也就是说，事件源会在IO读取到一部分数据的时候触发事件
// （触发事件不是自动的，程序员需要在读取到数据的时候自己触发事件并发布）
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;
    public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件
     * @param bb 它的参数会用过事件传递给消费者
     */
    public void onData(ByteBuffer bb){
        //1.可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence = ringBuffer.next();
        try {
            //2.用上面的索引取出一个空的事件用于填充（获取该序号对应的事件对象）
            LongEvent event = ringBuffer.get(sequence);
            //3.获取要通过事件传递的业务数据
            event.setValue(bb.getLong(0));
        } finally {
            //4.发布事件
            //注意，最后的 ringBuffer.publish 方法必须包含在 finally 中以确保必须得到调用；
            //      如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
            ringBuffer.publish(sequence);
        }
    }
}
