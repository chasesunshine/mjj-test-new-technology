package org.wanbang.study.ioc.ioc07.factory.support;

import org.wanbang.study.ioc.ioc07.factory.config.BeanDefinition;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:16
* @version 1.0
*/

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
