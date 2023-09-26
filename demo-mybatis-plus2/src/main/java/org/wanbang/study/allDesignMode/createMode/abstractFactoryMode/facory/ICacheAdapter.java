package org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.facory;

import java.util.concurrent.TimeUnit;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:11
* @version 1.0
*/

/**
 * 这个类的主要作⽤是让所有集群的提供⽅，能在统⼀的⽅法名称下进⾏操作。也⽅⾯后续的拓展
 *
 */
public interface ICacheAdapter {
    String get(String key);
    void set(String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}
