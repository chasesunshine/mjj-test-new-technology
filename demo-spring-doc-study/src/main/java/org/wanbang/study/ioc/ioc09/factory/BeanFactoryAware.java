package org.wanbang.study.ioc.ioc09.factory;
/**
 * @description: 容器感知类
 * @author majiajian
 * @date 2022/10/26 16:33
 * @version 1.0
 */

import org.wanbang.study.ioc.ioc09.exception.BeansException;

/**
 *  Interface to be implemented by beans that wish to be aware of their owning {@linkBeanFactory}.
 *  实现此接口，既能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
