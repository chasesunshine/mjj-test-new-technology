package org.wanbang.study.singletonMode;

// 懒汉式：默认不会实例化，什么时候用什么时候new。
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
