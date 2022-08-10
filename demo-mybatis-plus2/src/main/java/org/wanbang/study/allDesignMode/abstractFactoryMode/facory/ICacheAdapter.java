package org.wanbang.study.allDesignMode.abstractFactoryMode.facory;

import java.util.concurrent.TimeUnit;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:11
* @version 1.0
*/

public interface ICacheAdapter {
    String get(String key);
    void set(String key, String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}
