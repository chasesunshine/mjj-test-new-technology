package org.wanbang.study.singletonMode;

/**
 * 饿汉式天生就是   线程安全   的，可以直接用于多线程而不会出现问题
 *
 * 饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了。
 *
 */
// 饿汉式：类加载的时候就实例化，并且创建单例对象。


//线程安全：饿汉式在线程还没出现之前就已经实例化了，所以饿汉式一定是线程安全的。
public class Hungry{
    private Hungry(){}
    // 类加载的时候就实例化，并且创建单例对象
    private static final Hungry hungry=new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }
}