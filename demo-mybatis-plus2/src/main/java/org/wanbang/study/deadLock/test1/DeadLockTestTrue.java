package org.wanbang.study.deadLock.test1;

// 如果我们只运行Lock1呢？修改一下main函数，把线程b注释掉。
public class DeadLockTestTrue {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
        Thread a = new Thread(new Lock1());
        //Thread b = new Thread(new Lock2());
        a.start();
        //b.start();
    }
}

