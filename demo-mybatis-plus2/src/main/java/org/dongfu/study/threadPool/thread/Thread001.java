package org.dongfu.study.threadPool.thread;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 16:50
* @version 1.0
*/

public class Thread001 extends Thread{

    private int count = 10 ;

    public synchronized void run(){

        count-- ;

        System.out.println(this.currentThread().getName() + " count = "+ count);

    }

    public static void main(String[] args) {

        Thread001 ttt = new Thread001();

        Thread t1 = new Thread(ttt,"t1");

        Thread t2 = new Thread(ttt,"t2");

        Thread t3 = new Thread(ttt,"t3");

        Thread t4 = new Thread(ttt,"t4");

        Thread t5 = new Thread(ttt,"t5");

        t1.start();

        t2.start();

        t3.start();

        t4.start();

        t5.start();

    }

}