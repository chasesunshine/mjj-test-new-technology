package org.wanbang.study.ioc.ioc07.context;

import org.wanbang.study.ioc.ioc07.factory.ListableBeanFactory;
import org.wanbang.study.ioc.ioc07.factory.config.BeanFactoryPostProcessor;
import org.wanbang.study.ioc.ioc07.factory.config.BeanPostProcessor;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:28
* @version 1.0
*/

public interface ApplicationContext extends ListableBeanFactory {
    Map<String, BeanPostProcessor> getBeansOfType(Class<BeanPostProcessor> beanFactoryPostProcessorClass);
}
