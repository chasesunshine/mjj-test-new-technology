package org.wanbang.study.ioc.ioc08.factory;

import org.wanbang.study.ioc.ioc08.exception.BeansException;
import org.wanbang.study.ioc.ioc08.factory.config.AutowireCapableBeanFactory;
import org.wanbang.study.ioc.ioc08.factory.config.BeanDefinition;
import org.wanbang.study.ioc.ioc08.factory.config.BeanPostProcessor;
import org.wanbang.study.ioc.ioc08.factory.config.ConfigurableBeanFactory;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:11
* @version 1.0
*/

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}

