package org.wanbang.study.threadPool.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                System.out.println("正在执行的线程名:" + Thread.currentThread().getName());
            }
        };
        thread.setName("自定义的线程");
        thread.run();   //正在执行的线程名:main
        thread.start(); //正在执行的线程名:自定义的线程
    }
}
