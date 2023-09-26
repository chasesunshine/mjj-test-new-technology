package org.wanbang.study.ioc.ioc09.test;

import org.wanbang.study.ioc.ioc09.entity.PropertyValues;
import org.wanbang.study.ioc.ioc09.factory.config.BeanFactoryPostProcessor;
import org.wanbang.study.ioc.ioc09.entity.PropertyValue;
import org.wanbang.study.ioc.ioc09.exception.BeansException;
import org.wanbang.study.ioc.ioc09.factory.ConfigurableListableBeanFactory;
import org.wanbang.study.ioc.ioc09.factory.config.BeanDefinition;

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

