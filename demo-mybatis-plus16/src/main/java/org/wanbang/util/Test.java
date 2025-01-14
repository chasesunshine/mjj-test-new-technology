package org.wanbang.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 七、手撕多线程，三个线程轮流打印123/ijk，打印10次。（阿里一面手撕）
 */
public class Test {
    public static void main(String[] args) {
//        print123();

        // 创建一个需要3个线程到达才能继续的CyclicBarrier，并定义所有线程到达后要执行的动作
        final CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All workers have completed their tasks and are ready to proceed.");
        });

        // 启动三个工人线程
        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(barrier, "Worker-" + i)).start();
        }

    }

    public static void print123(){
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                System.out.println(1);
                s2.release();
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(2);
                s3.release();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                try {
                    s3.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(3);
                s1.release();
            }
        }).start();
    }

    // 定义工人线程类
    static class Worker implements Runnable {
        private final CyclicBarrier barrier;
        private final String name;

        Worker(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is working...");

                // 模拟工作过程，随机延迟以显示不同步性
//                Thread.sleep((long)(Math.random() * 2000));

                System.out.println(name + " has finished its work and is waiting at the barrier.");

                // 等待其他工人到达屏障
                barrier.await();

                System.out.println(name + " has been released from the barrier and can continue.");
            } catch (InterruptedException | BrokenBarrierException e) {
                System.err.println(name + " was interrupted or barrier was broken.");
                Thread.currentThread().interrupt();
            }
        }
    }

}
