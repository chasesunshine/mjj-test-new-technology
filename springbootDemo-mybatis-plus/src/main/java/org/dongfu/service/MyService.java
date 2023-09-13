package org.dongfu.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    ReentrantLock测试逻辑类
 */
public class MyService {
    private Lock lock = new ReentrantLock();//获取锁对象

    public void testMethod() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + (i+1));
            }
        }finally {
            lock.unlock();
        }
    }
}