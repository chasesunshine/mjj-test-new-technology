package org.wanbang.study.disruptorStudy;

public class Doc1 {
    // Disruptor 系列（一）快速入门
    // https://www.cnblogs.com/binarylei/p/9221547.html

    // 一、简介：
    // Disruptor：是一个开源的并发框架，能够在 无锁 的情况下实现网络的 Queue 并发操作，所以处理数据的能力比 Java 本身提供的并发类容器要大的多，
    // 在一个线程里每秒处理 6 百万订单。 可以把它当作一个轻量级的 MQ 和无锁的 BlockingQueue。

    // 二、Disruptor 特点
    // Disruptor 是一个 Java 的并发编程框架，大大的简化了并发程序开发的难度，在性能上也比 Java 本身提供的一些并发包要好。
    // Disruptor 是一个高性能异步处理框架，它实现了观察者模式，或者事件监听模式的实现。
    // Disruptor 是无锁的、CPU 友好，它不会清除缓存中的数据，只会覆盖，降低了垃圾回收机制启动的频率。


    //Disruptor 构造方法如下：
        //new Disruptor(
        //    EventFactory<T> eventFactory,   // 事件工厂类
        //    int ringBufferSize,             // RingBuffer 大小
        //    ThreadFactory threadFactory,    // ThreadFactory
        //    ProducerType producerType,      // 生产模式，ProducerType.SINGLE ProducerType.MULTI
        //    WaitStrategy waitStrategy)      // 等待策略，3种

    //WaitStrategy 策略类型：
        //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
        //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
        //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
}
