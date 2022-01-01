package org.wanbang.study.voliate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileTest {

    private static Boolean stop = false;//(1)
    //private static volatile Boolean stop = false;//(2)


    // https://blog.csdn.net/qq_24629159/article/details/84350958
    public static void main(String args[]) throws InterruptedException {
        //新建立一个线程
        Thread testThread = new Thread() {
            @Override
            public void run() {
                System.out.println("开始执行"+ System.currentTimeMillis());
                int i = 1;
                //不断的对i进行自增操作
                // 不使用  volatile关键字得时候 主线程的stop没有通知到子线程  ，  所以stop没有被更新到
                while (!stop) {
                    i++;
                    //log.info("执行while"+i);
                }
                System.out.println("Thread stop i=" + i);
            }
        };
        //启动该线程
        testThread.start();
        //休眠一秒
        Thread.sleep(1000);
        //主线程中将stop置为true
        stop = true;
        System.out.println(Thread.currentThread() + "now, in main thread stop is: " + stop);
        testThread.join();
    }

}

