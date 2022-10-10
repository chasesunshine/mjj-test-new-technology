package org.wanbang.study.ioc.ioc07.factory;

import org.wanbang.study.ioc.ioc07.context.ApplicationContext;
import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.config.*;

import java.util.Map;

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

