package org.wanbang.study.disruptorStudy.disruptor1.util;

// 我们从一个简单的例子开始学习 Disruptor：生产者传递一个 long 类型的值给消费者，
// 而消费者消费这个数据的方式仅仅是把它打印出来。首先声明一个 Event 来包含需要传递的数据：
public class LongEvent {
    private long value;
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
