package org.wanbang.study.ioc.ioc05.factory;

import org.wanbang.study.ioc.ioc05.exception.BeansException;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

/**
 * BeanFactory 中我们重载了一个含有入参信息 args 的 getBean 方法，这样就可以
 * 方便的传递入参给构造函数实例化了。
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
