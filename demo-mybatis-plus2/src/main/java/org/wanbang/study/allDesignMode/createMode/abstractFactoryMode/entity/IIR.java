package org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.entity;

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

public class IIR {
    private Logger logger = LoggerFactory.getLogger(IIR.class);
    private Map<String,String> dataMap = new ConcurrentHashMap<String,String>();

    public String get(String key) {
        logger.info("IIR 获取数据 {}",key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("IIR 设置数据 {} {}",key,value);
        dataMap.put(key,value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("IIR 设置ex数据 {} {} {} {}",key,value,timeout,timeUnit);
        dataMap.put(key,value);
    }

    public void del(String key) {
        logger.info("IIR 移除数据 {}",key);
        dataMap.remove(key);
    }
}
