package org.dongfu.study.ioc.ioc07.factory.config;

import org.dongfu.study.ioc.ioc07.factory.HierarchicalBeanFactory;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:04
* @version 1.0
*/

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}

