package org.dongfu.study.synchronizedConditonTest.actionObjectIsGeneralMethod;

public class Test1{

    public synchronized void test() {

    }

}

//等价于
/*
public class Test1{

    public void test() {
        //锁的是当前对象
        synchronized(this) {

        }
    }

}
*/
