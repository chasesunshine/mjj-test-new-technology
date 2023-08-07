package org.wanbang.study.synchronizedConditonTest.actionObjectIsStaticMethod;

public class Test2{

    public synchronized static void test() {

    }

}

//等价于
/*
    public class Test2{

        public static void test() {
            //锁的是类对象，类对象只有一个
            synchronized(Test2.class) {

            }
        }

    }
 */
