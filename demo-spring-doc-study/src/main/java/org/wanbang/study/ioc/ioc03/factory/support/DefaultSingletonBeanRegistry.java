package org.wanbang.study.ioc.ioc03.factory.support;

import org.wanbang.study.ioc.ioc03.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:16
* @version 1.0
*/

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
