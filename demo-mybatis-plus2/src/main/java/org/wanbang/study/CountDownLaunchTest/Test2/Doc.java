package org.wanbang.study.CountDownLaunchTest.Test2;

/**
 * CountDownLatch 主要用于协调多个线程的执行顺序，确保一些线程在其他线程完成特定任务之前不会继续执行。下面是一些常见的使用场景及其对应的简单示例代码：
 *
 * 场景：等待所有线程完成
 * 假设你有一个任务，该任务需要并行地从多个数据源获取信息，然后汇总这些信息。在这种情况下，你可以使用 CountDownLatch 来确保所有数据获取线程完成工作之后，主线程才继续进行汇总。
 *
 * 示例代码
 * CountDownLatchExample.class
 * 在这个例子中，我们创建了一个 CountDownLatch 对象，并设置了初始计数值为 5，表示有 5 个线程需要完成任务。每个线程在完成任务后调用 countDown() 方法，这会减少计数器的值。latch.await() 方法会在计数器变为零之前阻塞主线程，确保所有任务都已经完成。
 *
 *
 *
 * 场景：系统初始化
 * 另一个常见的使用场景是在系统启动时进行初始化。假设系统启动时需要完成多项初始化任务，如数据库连接、缓存初始化等。我们可以使用 CountDownLatch 来确保所有初始化任务完成之后再让系统进入就绪状态。
 *
 * 示例代码
 * InitializationExample.class
 * 这个例子展示了如何在系统启动时使用 CountDownLatch 来确保所有初始化任务完成。每个初始化任务都在自己的线程中执行，并在完成后调用 countDown()。main 方法中的 latch.await() 会等待所有初始化任务完成，直到计数器为零。这样可以保证系统在完全初始化之后再对外提供服务。
 *
 */
public class Doc {
}
