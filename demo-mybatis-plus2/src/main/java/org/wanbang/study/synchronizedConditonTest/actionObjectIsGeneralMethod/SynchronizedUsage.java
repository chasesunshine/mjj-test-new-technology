package org.wanbang.study.synchronizedConditonTest.actionObjectIsGeneralMethod;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:41
 * @description
 */
public class SynchronizedUsage {

    public synchronized void synchronizedMethod1() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "同步方法1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void synchronizedMethod2() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "同步方法2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unsafeMethod() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "普通方法");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
