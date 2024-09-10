package org.wanbang.study.CountDownLaunchTest.Test2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 模拟一些耗时操作
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 完成了任务");
                    latch.countDown(); // 减少计数器
                }
            }).start();
        }

        // 等待所有线程完成任务
        latch.await();

        System.out.println("所有线程已完成，继续执行后续任务...");
    }
}
