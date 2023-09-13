package org.dongfu.study.synchronizedConditonTest.actionObjectIsObject;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:41
 * @description
 */
public class SynchronizedUsage {

    private void print() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步代码块——锁的对象是对象实例
     */
    public void synchronizedCodelockObjct() {
        // 这里锁住的是当前对象
        synchronized(this) {
            print();
        }
    }

    /**
     * 同步代码块——锁的对象是对象实例
     */
    public void synchronizedCodelockObjct2() {
        Object obj = new Object();
        // 这里锁住的是当前对象
        synchronized(obj) {
            System.out.println("锁的是object对象");
            print();
        }
    }

}
