package org.wanbang.study.ioc.ioc07.factory;

import org.wanbang.study.ioc.ioc07.factory.config.BeanFactoryPostProcessor;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:11
* @version 1.0
*/

public interface ListableBeanFactory {
    Map<String, BeanFactoryPostProcessor> getBeansOfType(Class<BeanFactoryPostProcessor> beanFactoryPostProcessorClass);
}
