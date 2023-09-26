package org.wanbang.study.delayQueue.javaDelayQueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

// DelayQueue的put方法是线程安全的，因为put方法内部使用了ReentrantLock锁进行线程同步。DelayQueue还提供了两种出队的方法poll()和take() ，
// poll()为非阻塞获取，没有到期的元素直接返回null；take()阻塞方式获取，没有到期的元素线程将会等待。
public class DelayQueueDemoTest {

    public static void main(String[] args) throws InterruptedException {
        Order Order1 = new Order("Order1", 6, TimeUnit.SECONDS);
        Order Order2 = new Order("Order2", 12, TimeUnit.SECONDS);
        Order Order3 = new Order("Order3", 16, TimeUnit.SECONDS);
        DelayQueue<Order> delayQueue = new DelayQueue<>();
        delayQueue.put(Order1);
        delayQueue.put(Order2);
        delayQueue.put(Order3);

        System.out.println("订单延迟队列开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        while (delayQueue.size() != 0) {
            /**
             * 取队列头部元素是否过期
             */
            Order task = delayQueue.poll();
            if (task != null) {
                System.out.format("订单:{%s}被取消, 取消时间:{%s}\n", task.name, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            Thread.sleep(2000);
        }
    }
}
