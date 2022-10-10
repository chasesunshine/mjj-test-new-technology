package org.wanbang.study.ioc.ioc07.test;

import org.wanbang.study.ioc.ioc07.entity.PropertyValue;
import org.wanbang.study.ioc.ioc07.entity.PropertyValues;
import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.ConfigurableListableBeanFactory;
import org.wanbang.study.ioc.ioc07.factory.config.BeanDefinition;
import org.wanbang.study.ioc.ioc07.factory.config.BeanFactoryPostProcessor;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 20:12
* @version 1.0
*/

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}

