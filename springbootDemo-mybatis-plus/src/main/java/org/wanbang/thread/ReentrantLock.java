package org.wanbang.thread;

/**
 *
 * 可重入锁也叫递归锁，指的是同一个线程，如果外层函数拥有此锁之后，内层的函数也可以继续获取该锁。
 * 在Java语言中ReentrantLock和synchronized都是可重入锁。
 *
 * http://www.51testing.com/html/86/n-4473886.html
 * @Author mjj
 * @Date 15:06 2021/11/8
 * @Param
 * @return
 **/
public class ReentrantLock {
    public static void main(String[] args) {
        reentrantA();
    }
    private static synchronized void reentrantA() {
        System.out.println(Thread.currentThread().getName() + " thread runs reentrantA()");
        reentrantB();
    }
    private static synchronized void reentrantB() {
        System.out.println(Thread.currentThread().getName() + " thread runs reentrantB()");
    }
}
