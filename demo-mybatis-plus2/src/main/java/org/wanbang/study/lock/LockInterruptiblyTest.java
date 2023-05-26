package org.wanbang.study.lock;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyTest implements Runnable {
    private Count count;

    public LockInterruptiblyTest(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            count.interrupt(count.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + ",Request Lock Interrupted...");
        }
    }

    /**
     * 因此，对于方法void lockInterruptibly() throws InterruptedException;
     * 和boolean tryLock(long var1, TimeUnit var3) throws InterruptedException;
     * 都应该将调用语句放在try{}catch{}之外。
     *
     * @param args
     */
    public static void main(String[] args) {
        Count count1 = new Count("Count Instance 1:");
        Thread thread1 = new Thread(new LockInterruptiblyTest(count1));
        Thread thread2 = new Thread(new LockInterruptiblyTest(count1));
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
}


@Data
class Count{
    private Lock lockTry = new ReentrantLock();
    private String name;

    public Count(String name) {
        this.name = name;
    }

    public void interrupt(String name) throws InterruptedException {
        lockTry.lockInterruptibly();
        try {
            int y = 0;
            for (int i = 0; i < 1000; i++) {
                y++;
                System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockTry.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock ...");
        }
    }
}