package org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.service;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:34
* @version 1.0
*/

public interface CacheService {
    public String get(String key, int redisType);
    
    public void set(String key, String value, int redisType);

    void set(String key, String value);

    String get(String key);
}
