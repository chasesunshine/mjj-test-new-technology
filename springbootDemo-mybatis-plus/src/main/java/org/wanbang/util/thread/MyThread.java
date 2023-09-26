package org.wanbang.util.thread;

import org.wanbang.service.MyService;

/**
 *    ReentrantLock测试逻辑线程
 */
public class MyThread extends Thread{

    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
        this.start();
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
