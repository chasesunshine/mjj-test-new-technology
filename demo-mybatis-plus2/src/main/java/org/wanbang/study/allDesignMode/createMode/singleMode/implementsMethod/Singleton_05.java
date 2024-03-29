package org.wanbang.study.allDesignMode.createMode.singleMode.implementsMethod;
/**
* @description: 5. 双重锁校验(线程安全)
* @author majiajian
* @date 2022/8/11 15:15
* @version 1.0
*/

/**
 *
 * 双重锁的⽅式是⽅法级锁的优化，减少了部分获取实例的耗时。
 * 同时这种⽅式也满⾜了懒加载。
 *
 */
public class Singleton_05 {
    private static Singleton_05 instance;
    private Singleton_05() {
    }
    public static Singleton_05 getInstance(){
        if(null != instance) return instance;
        synchronized (Singleton_05.class){
            if (null == instance){
                instance = new Singleton_05();
            }
        }
        return instance;
    }
}
