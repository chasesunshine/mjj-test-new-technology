package org.dongfu.study.allDesignMode.createMode.singleMode.implementsMethod;
/**
* @description: 1. 懒汉模式(线程不安全)
* @author majiajian
* @date 2022/8/11 15:10
* @version 1.0
*/

/**
 *
 * 单例模式有⼀个特点就是不允许外部直接创建，也就是 new Singleton_01() ，因此这⾥在默认
 * 的构造函数上添加了私有属性 private 。
 * ⽬前此种⽅式的单例确实满⾜了懒加载，但是如果有多个访问者同时去获取对象实例你可以想象成
 * ⼀堆⼈在抢厕所，就会造成多个同样的实例并存，从⽽没有达到单例的要求。
 *
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}