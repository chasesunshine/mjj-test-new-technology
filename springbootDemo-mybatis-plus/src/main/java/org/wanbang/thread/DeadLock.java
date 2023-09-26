package org.wanbang.thread;

/**
 *
 * 模拟一个死锁
 * 死锁指的是两个线程同时占有两个资源，同时又在等待对方释放锁资源
 *
 * http://www.51testing.com/html/86/n-4473886.html
 * @Author mjj
 * @Date 14:52 2021/11/8
 * @Param
 * @return
 **/
import java.util.concurrent.TimeUnit;
public class DeadLock {

    public static void main(String[] args) {
        deadLock();
    }


    private static void deadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        //线程1拥有 lock1 试图获取 lock2
        new Thread(() -> {
            synchronized (lock1) {

                System.out.println(Thread.currentThread().getName() + "获取lock1");
                try{
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "等待3秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "获取lock2");
                }

            }
        }, "AAA").start();


        //线程2拥有lock2
        new Thread(() -> {
            synchronized (lock2) {

                System.out.println(Thread.currentThread().getName() + "获取lock2");
                try{
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "等待3秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "获取lock1");
                }

            }
        }, "BBB").start();
    }
}