package org.wanbang.study.ioc.ioc02.step01.springframework;
/**
* @description: 1. BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
* @author majiajian
* @date 2022/9/2 15:47
* @version 1.0
*/

/**
 * 目前的 Bean 定义中，只有一个 Object 用于存放 Bean 对象。如果感兴趣可以参
 * 考 Spring 源码中这个类的信息，名称都是一样的。
 *
 * 不过在后面陆续的实现中会逐步完善 BeanDefinition 相关属性的填充，例如：
 * SCOPE_SINGLETON、SCOPE_PROTOTYPE、ROLE_APPLICATION、
 * ROLE_SUPPORT、ROLE_INFRASTRUCTURE 以及 Bean Class 信息。
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}

