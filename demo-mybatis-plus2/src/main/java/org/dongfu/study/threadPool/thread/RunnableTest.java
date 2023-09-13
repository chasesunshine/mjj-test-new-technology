package org.dongfu.study.threadPool.thread;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在执行的线程名:" + Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable);
        thread.setName("自定义的线程");
        thread.run();   //正在执行的线程名:main
        thread.start(); //正在执行的线程名:自定义的线程
    }
}

