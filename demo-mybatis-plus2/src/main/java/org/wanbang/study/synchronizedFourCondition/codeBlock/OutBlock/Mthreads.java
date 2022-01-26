package org.wanbang.study.synchronizedFourCondition.codeBlock.OutBlock;

public class Mthreads implements Runnable {
    private int count;

    public Mthreads() {
        count = 0;
    }

    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("有 synchronized :"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("没有 synchronized :"+Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("mt1")) {
            countAdd();
        } else if (threadName.equals("mt2")) {
            printCount();
        }
    }
}