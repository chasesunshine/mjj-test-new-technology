package org.wanbang.study.ioc.ioc09.factory;

import org.wanbang.study.ioc.ioc09.exception.BeansException;
import org.wanbang.study.ioc.ioc09.factory.config.AutowireCapableBeanFactory;
import org.wanbang.study.ioc.ioc09.factory.config.ConfigurableBeanFactory;
import org.wanbang.study.ioc.ioc09.factory.config.BeanDefinition;
import org.wanbang.study.ioc.ioc09.factory.config.BeanPostProcessor;

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

