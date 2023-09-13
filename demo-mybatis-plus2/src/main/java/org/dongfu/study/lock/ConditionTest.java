package org.dongfu.study.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest implements Runnable{

    private Lock lockTry = new ReentrantLock();
    private Condition condition = lockTry.newCondition();

    public void signal(String name) {
        lockTry.lock();
        System.out.println(name+ "signal:"+ Thread.currentThread().getName() + ",Request Lock...");
        try {
            condition.signal();
            System.out.println(name + "-->CurrThread: Wait for the Thread to wake up...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockTry.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock...");
        }
    }

    public void wait(String name) {
        lockTry.lock();
        System.out.println(name+ "wait:"+Thread.currentThread().getName() + ",Request Lock...");
        try {
            int y = 0;
            for (int i = 0; i < 5; i++) {
                y++;
                if (i == 2) {
                    System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " is waiting...");
                    condition.await();
                }
                System.out.println(name + "-->CurrThread:" + Thread.currentThread().getName() + " y=" + y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockTry.unlock();
            System.out.println(Thread.currentThread().getName() + ",Release Lock...");
        }
    }

    @Override
    public void run() {
        wait(condition.getClass().getName());
    }


    /**
     * condition类的使用
     * condition类，是Java提供的等待/通知类。
     *
     * 建立两个线程，分别调用这两个方法；注意线程在调用signal方法时，让线程睡眠几秒，
     * 这样在输出结果是就能看出很明显的结果。
     *
     * @param args
     */
    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        new Thread(conditionTest).start();
        new Thread(conditionTest).start();
    }
}
