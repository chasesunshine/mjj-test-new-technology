package org.wanbang.study.ioc.ioc07.factory.config;

import org.wanbang.study.ioc.ioc07.exception.BeansException;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/10/9 18:27
 * @version 1.0
 */

/**
 *
 * 在 Spring 源码中有这样一段描述 Factory hook that allows for
 * custom modification of new bean instances,e.g. checking
 * for marker interfaces or wrapping them with proxies.也就是
 * 提供了修改新实例化 Bean 对象的扩展点。
 *  另外此接口提供了两个方法：postProcessBeforeInitialization 用于在
 * Bean 对象执行初始化方法之前，执行此方法、
 * postProcessAfterInitialization 用于在 Bean 对象执行初始化方法之
 * 后，执行此方法.
 *
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}