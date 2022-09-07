package org.wanbang.study.ioc.ioc03.factory.config;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
