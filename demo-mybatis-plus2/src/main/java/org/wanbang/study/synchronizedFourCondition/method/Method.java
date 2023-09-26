package org.wanbang.study.synchronizedFourCondition.method;

import org.wanbang.study.synchronizedFourCondition.codeBlock.InBlock.SyncThread;

public class Method {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        SyncThread syncThread = new SyncThread();
        //SyncThread syncThread1 = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        //Thread thread2 = new Thread(syncThread1, "SyncThread2");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }

}
