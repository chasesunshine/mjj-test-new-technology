package org.wanbang.study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest implements Runnable{

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock writeLock = lock.writeLock();
    private Lock readLock = lock.readLock();

    public void write(String name) {
        writeLock.lock();
        try {
            int y = 0;
            for (int i = 0; i < 3; i++) {
                y++;
                System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Abnormal exit of write method...");
        } finally {
            System.out.println(Thread.currentThread().getName() + ",Release Write Lock ...");
            writeLock.unlock();
        }
    }

    public void read(String name) {
        readLock.lock();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " output=" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Abnormal exit of read method...");
        } finally {
            System.out.println(Thread.currentThread().getName() + ",Release Read Lock ...");
            readLock.unlock();
        }
    }

    @Override
    public void run() {
        read(readLock.getClass().getName());
    }


    /**
     * 两个线程都调用read方法，运行：
     * 从结果看，可以多线程一起读共享数据。
     *
     * 一个线程调用方法read，一个线程调用方法write，运行：
     * 从结果看，不管是先调用读还是写，都是一个获取锁执行完成释放锁后，另一个线程才执行。它们之间是互斥的。
     *
     * @param args
     */
    public static void main(String[] args) {
        ReentrantReadWriteLockTest reentrantReadWriteLockTest = new ReentrantReadWriteLockTest();
        new Thread(reentrantReadWriteLockTest).start();
        new Thread(reentrantReadWriteLockTest).start();
    }

}
