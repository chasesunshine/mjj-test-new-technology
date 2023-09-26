package org.wanbang.study.ioc.ioc07.factory.config;

import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.BeanFactory;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:04
* @version 1.0
*/

public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
