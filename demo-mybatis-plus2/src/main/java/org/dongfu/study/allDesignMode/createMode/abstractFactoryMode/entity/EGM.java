package org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/10 20:14
 * @version 1.0
 */

public class EGM {
    private Logger logger = LoggerFactory.getLogger(EGM.class);
    private Map<String,String> dataMap = new ConcurrentHashMap<String,String>();

    public String gain(String key) {
        logger.info("EGM 获取数据 {}",key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("EGM 设置数据 {} {}",key,value);
        dataMap.put(key,value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("EGM 设置ex数据 {} {} {} {}",key,value,timeout,timeUnit);
        dataMap.put(key,value);
    }

    public void delete(String key) {
        logger.info("EGM 移除数据 {}",key);
        dataMap.remove(key);
    }
}
