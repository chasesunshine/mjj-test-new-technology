package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.ScheduledExecutorServiceTest;

/**
 * ScheduledExecutorService 使用
 *
 * https://blog.csdn.net/wangxuelei036/article/details/109327699
 *
 */
public class Doc {

    /**
     * ScheduledExecutorService，我平时没有用过，他的最大优点除了线程池的特性以外，可以实现循环或延迟任务。
     *
     * ScheduledExecutorService,是基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响。
     *
     * 需要注意,只有当调度任务来的时候,ScheduledExecutorService才会真正启动一个线程,其余时间ScheduledExecutorService都是出于轮询任务的状态。
     *
     */
}
