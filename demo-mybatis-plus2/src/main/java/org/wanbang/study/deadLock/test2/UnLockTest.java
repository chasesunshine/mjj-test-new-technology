package org.wanbang.study.deadLock.test2;

import java.util.concurrent.Semaphore;

// 为了解决这个问题，我们不使用显示的去锁，我们用信号量去控制。

// 信号量可以控制资源能被多少线程访问，这里我们指定只能被一个线程访问，就做到了类似锁住。
// 而信号量可以指定去获取的超时时间，我们可以根据这个超时时间，去做一个额外处理。

//对于无法成功获取的情况，一般就是重复尝试，或指定尝试的次数，也可以马上退出。
public class UnLockTest {
    public static String obj1 = "obj1";
    public static final Semaphore a1 = new Semaphore(1);
    public static String obj2 = "obj2";
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {
        LockAa la = new LockAa();
        new Thread(la).start();
        LockBb lb = new LockBb();
        new Thread(lb).start();
    }
}
