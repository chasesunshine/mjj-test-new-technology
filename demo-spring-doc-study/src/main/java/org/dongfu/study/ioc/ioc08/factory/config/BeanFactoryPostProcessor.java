package org.dongfu.study.ioc.ioc08.factory.config;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:27
* @version 1.0
*/

import org.dongfu.study.ioc.ioc08.exception.BeansException;
import org.dongfu.study.ioc.ioc08.factory.ConfigurableListableBeanFactory;

/**
 *
 *  在 Spring 源码中有这样一段描述 Allows for custom modification of
 * an application context's bean definitions,adapting the
 * bean property values of the context's underlying bean
 * factory. 其实也就是说这个接口是满足于在所有的 BeanDefinition 加载完成
 * 后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制。
 *
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}