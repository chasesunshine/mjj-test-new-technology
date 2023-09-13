package org.dongfu.study.ioc.ioc10.factory;

import org.dongfu.study.ioc.ioc10.exception.BeansException;
import org.dongfu.study.ioc.ioc10.factory.config.AutowireCapableBeanFactory;
import org.dongfu.study.ioc.ioc10.factory.config.BeanDefinition;
import org.dongfu.study.ioc.ioc10.factory.config.BeanPostProcessor;
import org.dongfu.study.ioc.ioc10.factory.config.ConfigurableBeanFactory;

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

