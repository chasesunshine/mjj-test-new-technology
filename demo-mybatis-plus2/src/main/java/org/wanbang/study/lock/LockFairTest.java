package org.wanbang.study.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFairTest {
    private Lock lockFair = new ReentrantLock(true);//true 设置公平锁 false 不设置

    public void fairLock() {
        try {
            lockFair.lock();
            System.out.println(Thread.currentThread().getName() + ",Request Lock...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockFair.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock...");
        }
    }


    /**
     * 公平锁的使用
     * 公平锁即尽量以请求锁的顺序来获取锁
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        LockFairTest lockFairTest = new LockFairTest();
        for (int i = 0; i < 5; i++) {
            threadList.add(new Thread(new MyRunnable(lockFairTest)));
        }

        for (Thread thread1 : threadList) {
            thread1.start();
        }
    }

}

class MyRunnable implements Runnable {
    private LockFairTest count;
    public MyRunnable(LockFairTest count) {
        this.count = count;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running...");
        count.fairLock();
    }
}
