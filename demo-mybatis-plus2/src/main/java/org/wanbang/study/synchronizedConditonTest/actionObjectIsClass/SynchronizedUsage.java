package org.wanbang.study.synchronizedConditonTest.actionObjectIsClass;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:41
 * @description
 */
public class SynchronizedUsage {

    private void print(String s) {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + name + "-" + s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步代码块——锁的对象是类
     */
    public void synchronizedCodelockClass(){
        // 这里锁住的是类
        synchronized (SynchronizedUsage.class){
            print("方法1");
        }
    }

    /**
     * 同步代码块——锁的对象是类
     */
    public void synchronizedCodelockClass2(){
        // 这里锁住的是类
        synchronized (SynchronizedUsage.class){
            print("方法2");
        }
    }

}
