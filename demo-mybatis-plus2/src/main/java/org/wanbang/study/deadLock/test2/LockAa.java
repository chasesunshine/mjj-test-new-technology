package org.wanbang.study.deadLock.test2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class LockAa implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockA 开始执行");
            while (true) {
                if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " LockA 锁住 obj1");
                    if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " LockA 锁住 obj2");
                        Thread.sleep(60 * 1000); // do something
                    }else{
                        System.out.println(new Date().toString() + "LockA 锁 obj2 失败");
                    }
                }else{
                    System.out.println(new Date().toString() + "LockA 锁 obj1 失败");
                }
                UnLockTest.a1.release(); // 释放
                UnLockTest.a2.release();
                Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
