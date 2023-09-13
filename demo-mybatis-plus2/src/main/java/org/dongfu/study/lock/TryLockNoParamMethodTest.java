package org.dongfu.study.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockNoParamMethodTest implements Runnable{
    private Lock lockTry = new ReentrantLock();

    @Override
    public void run() {
        tryLock(lockTry.getClass().getName());
    }

    public void tryLock(String name) {
        if (lockTry.tryLock()) {
            System.out.println(Thread.currentThread().getName() + ",Request Lock success...");
            try {
                int y = 0;
                for (int i = 0; i < 3; i++) {
                    y++;
                    System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ",Release Lock ...");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ",Request Lock failed...");
        }
    }

    /**
     * 线程1申请锁成功，线程0申请锁失败了，此时他并没有继续在等待线程1的执行完成。
     *
     * @param args
     */
    public static void main(String[] args) {
        TryLockNoParamMethodTest tryLockNoParamMethodTest = new TryLockNoParamMethodTest();
        new Thread(tryLockNoParamMethodTest).start();
        new Thread(tryLockNoParamMethodTest).start();
    }

}
