package org.dongfu.study.synchronizedConditonTest.actionObjectIsStaticMethod;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:41
 * @description
 */
public class SynchronizedUsage {

    /**
     * 同步静态方法
     */
    public static synchronized void synchronizedStaticmethod() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + "同步静态方法1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
