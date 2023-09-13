package org.dongfu.study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMethodTest implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        testLock(lock.getClass().getName());
    }

    public void testLock(String name) {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ",Request Lock...");
        try {
            int y = 0;
            for (int i = 0; i < 3; i++) {
                y++;
                System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock ...");
        }
    }

    /**
     * ReentrantLock类实现了接口Lock，新增了一些方法；Lock自己加锁，
     * 用完后自己在释放掉锁；如果加锁的程序在运行过程中发生异常，也不会释放锁，
     * 那么就需要我们自己进行处理了，所以我们在使用Lock时会将其放入try{}catch{}finally{}中，
     * 将释放锁的操作放入finally中。
     * 传入同一实例对象，在两个线程中调用此方法
     *
     */
    public static void main(String[] args) {
        LockMethodTest lockMethodTest = new LockMethodTest();
        new Thread(lockMethodTest).start();
        new Thread(lockMethodTest).start();
    }

}
