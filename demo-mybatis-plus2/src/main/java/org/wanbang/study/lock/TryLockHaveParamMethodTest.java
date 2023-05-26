package org.wanbang.study.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockHaveParamMethodTest implements Runnable{
    private Lock lockTry = new ReentrantLock();

    @Override
    public void run() {
        tryLock(lockTry.getClass().getName());
    }

    public void tryLock(String name) {
        try {
//            if (lockTry.tryLock(2000, TimeUnit.MILLISECONDS)) {
            if (lockTry.tryLock(1, TimeUnit.MICROSECONDS)) {
                System.out.println(Thread.currentThread().getName() + ",Request Lock success...");

                int y = 0;
                for (int i = 0; i < 3; i++) {
                    y++;
                    System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ",Request Lock failed...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockTry.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock ...");
        }
    }

    /**
     * tryLock(long l, TimeUnit t)第一个参数表示要等待的时间，第二个参数表示时间单位。
     *
     * 一个线程在获取到锁之后，另一线程在获取的话肯定就失败了，但是这里设置了时间之后，
     * 在获取不到线程的时候就进行等待设定的时间之后在进行获取，获取到了就返回true，获取不到或者中途线程中断了就返回false。
     *
     *
     * lockTry.tryLock(2000, TimeUnit.MILLISECONDS)  两个线程正常执行
     * lockTry.tryLock(1, TimeUnit.MICROSECONDS)    其中一个执行失败
     * @param args
     */
    public static void main(String[] args) {
        TryLockHaveParamMethodTest tryLockHaveParamMethodTest = new TryLockHaveParamMethodTest();
        new Thread(tryLockHaveParamMethodTest).start();
        new Thread(tryLockHaveParamMethodTest).start();
    }

}
