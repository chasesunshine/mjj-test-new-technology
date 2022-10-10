package org.wanbang.study.ioc.ioc07.factory.support;

import org.springframework.beans.factory.DisposableBean;
import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
* @description: DefaultSingletonBeanRegistry
* @author majiajian
* @date 2022/9/7 18:16
* @version 1.0
*/

/**
 * 在 DefaultSingletonBeanRegistry 中主要实现 getSingleton 方法，同时实现了一个
 * 受保护的 addSingleton 方法，这个方法可以被继承此类的其他类调用。包括：
 * AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用。
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