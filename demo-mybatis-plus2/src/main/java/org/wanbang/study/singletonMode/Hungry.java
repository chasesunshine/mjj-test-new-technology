package org.wanbang.study.singletonMode;

// 饿汉式：类加载的时候就实例化，并且创建单例对象。
public class Hungry{
    private Hungry(){}
    // 类加载的时候就实例化，并且创建单例对象
    private static final Hungry hungry=new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }
}