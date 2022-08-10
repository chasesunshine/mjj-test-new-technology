package org.wanbang.study.allDesignMode.abstractFactoryMode.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.abstractFactoryMode.entity.IIR;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:36
* @version 1.0
*/

public class RedisUtils {
    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);
    private Map<String,String> dataMap = new ConcurrentHashMap<String,String>();

    public String get(String key) {
        logger.info("RedisUtils 获取数据 {}",key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("RedisUtils 设置数据 {} {}",key,value);
        dataMap.put(key,value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("RedisUtils 设置ex数据 {} {} {} {}",key,value,timeout,timeUnit);
        dataMap.put(key,value);
    }

    public void delete(String key) {
        logger.info("RedisUtils 移除数据 {}",key);
        dataMap.remove(key);
    }
}
