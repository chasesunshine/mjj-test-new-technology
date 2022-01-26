package org.wanbang.study.synchronizedFourCondition.codeBlock.InBlock;

public class BlockErrorTest {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        SyncThreadError syncThread = new SyncThreadError();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
