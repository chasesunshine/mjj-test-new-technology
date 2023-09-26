package org.wanbang.study.disruptorStudy;
/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/30 11:10
 * @version 1.0
 */

//https://blog.csdn.net/li12412414/article/details/82317888?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-82317888-blog-123363147.pc_relevant_multi_platform_whitelistv4&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-82317888-blog-123363147.pc_relevant_multi_platform_whitelistv4&utm_relevant_index=5
public class Doc6 {

//    Disruptor的一些核心介绍

//1.RingBuffer
//    RingBuffer是其核心，生产者向RingBuffer中写入元素，消费者从RingBuffer中消费元素。
//    随着你不停地填充这个buffer（可能也会有相应的读取），这个序号会一直增长，直到绕过这个环。
//    槽的个数是2的N次方更有利于基于二进制的计算机进行计算。（注：2的N次方换成二进制就是1000，100，10，1这样的数字， sequence & （array length－1） = array index，比如一共有8槽，3&（8－1）=3，HashMap就是用这个方式来定位数组元素的，这种方式比取模的速度更快。）
//    会预先分配内存,可以做到完全的内存复用。在系统的运行过程中，不会有新的空间需要分配或者老的空间需要回收。因此，可以大大减少系统分配空间以及回收空间的额外开销。
//    关于RingBuffer可以直观的看一下下面的这幅图片（网上copy的），表示取到编号为4的数据。
//
//2.消费者等待策略
//    BlockingWaitStrategy：这是默认的策略。使用锁和条件进行数据的监控和线程的唤醒。因为涉及到线程的切换，是最节省CPU，但在高并发下性能表现最糟糕的一种等待策略。
//    SleepingWaitStrategy:会自旋等待数据，如果不成功，才让出cpu，最终进行线程休眠，以确保不占用太多的CPU数据，因此可能产生比较高的平均延时。比较适合对延时要求不高的场合，好处是对生产者线程的影响最小。典型的应用场景是异步日志。
//    YieldingWaitStrategy:用于低延时的场合。消费者线程不断循环监控缓冲区变化，在循环内部，会使用Thread.yield()让出cpu给别的线程执行时间。
//    BusySpinWaitStrategy:开启的是一个死循环监控，消费者线程会尽最大努力监控缓冲区变化，因此，CPU负担比较大

//3.Disruptor的应用场景
//    Disruptor号称能够在一个线程里每秒处理 6 百万订单,实际上我也没有测试过。Disruptor实际上内部是使用环形队列来实现的，所以一般来说，在消费者和生产者的场景中都可以考虑使用Disruptor。比如像日志处理之类的。实际上，我个人觉得Disruptor就像是Java里面的ArrayBlockingQueue的替代者，因为Disruptor可以提供更高的并发度和吞吐量。从下面这幅官网的图就可以直观的感受到Disruptor和ArrayBlockingQueue之间的效率的对比。(注意这是一个对数对数尺度，不是线性的。)


}
