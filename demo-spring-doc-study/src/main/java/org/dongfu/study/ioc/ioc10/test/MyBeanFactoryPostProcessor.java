package org.dongfu.study.ioc.ioc10.test;

import org.dongfu.study.ioc.ioc10.factory.config.BeanFactoryPostProcessor;
import org.dongfu.study.ioc.ioc10.entity.PropertyValue;
import org.dongfu.study.ioc.ioc10.entity.PropertyValues;
import org.dongfu.study.ioc.ioc10.exception.BeansException;
import org.dongfu.study.ioc.ioc10.factory.ConfigurableListableBeanFactory;
import org.dongfu.study.ioc.ioc10.factory.config.BeanDefinition;

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

