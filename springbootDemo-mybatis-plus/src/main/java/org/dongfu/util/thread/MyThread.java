package org.dongfu.util.thread;

import org.dongfu.service.MyService;

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
