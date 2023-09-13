package org.dongfu.study.allDesignMode.createMode.singleMode.implementsMethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description: 0. 静态类使⽤
* @author majiajian
* @date 2022/8/11 15:09
* @version 1.0
*/

/**
 *
 * 以上这种⽅式在我们平常的业务开发中⾮常场常⻅，这样静态类的⽅式可以在第⼀次运⾏的时候直
 * 接初始化Map类，同时这⾥我们也不需要到延迟加载在使⽤。
 * 在不需要维持任何状态下，仅仅⽤于全局访问，这个使⽤使⽤静态类的⽅式更加⽅便。
 * 但如果需要被继承以及需要维持⼀些特定状态的情况下，就适合使⽤单例模式
 *
 */
public class Singleton_00 {
    public static Map<String,String> cache = new ConcurrentHashMap<String, String>();

}
