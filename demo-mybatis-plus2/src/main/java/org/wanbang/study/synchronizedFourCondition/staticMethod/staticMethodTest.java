package org.wanbang.study.synchronizedFourCondition.staticMethod;

public class staticMethodTest {
    public static void main(String[] args) {
        System.out.println("使用关键字静态synchronized");
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
