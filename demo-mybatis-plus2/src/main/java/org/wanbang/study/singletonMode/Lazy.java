package org.wanbang.study.singletonMode;

/**
 * 懒汉式本身是非线程安全的
 */
// 懒汉式：默认不会实例化，什么时候用什么时候new。


// 懒汉式加载是在使用时才会去new 实例的，那么你去new的时候是一个动态的过程，是放到方法中实现的，比如：
//如果这个时候有多个线程访问这个实例，这个时候实例还不存在，还在new，就会进入到方法中，有多少线程就会new出多少个实例。
// 一个方法只能return一个实例，那最终return出哪个呢？是不是会覆盖很多new的实例？
// 这种情况当然也可以解决，那就是加同步锁，避免这种情况发生 。
public class Lazy{
    private Lazy(){}
    //默认不会实例化，什么时候用什么时候new
    private static Lazy lazy=null;

    public static synchronized Lazy getInstance(){
        if(lazy==null){
            lazy=new Lazy();
        }
        return lazy;
    }
}
