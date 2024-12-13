package org.wanbang.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 七、手撕多线程，三个线程轮流打印123/ijk，打印10次。（阿里一面手撕）
 */
public class Test {
    public static void main(String[] args) {
        print123();
    }

    public static void print123(){
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                System.out.println(1);
                s2.release();
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                try {
                    s2.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(2);
                s3.release();
            }
        }).start();

        new Thread(() -> {
            for(int i = 0;i < 10;i++){
                try {
                    s3.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(3);
                s1.release();
            }
        }).start();

    }
}
