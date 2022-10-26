package org.wanbang.study.ioc.ioc09.factory.support;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.wanbang.study.ioc.ioc09.exception.BeansException;
import org.wanbang.study.ioc.ioc09.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/13 19:53
* @version 1.0
*/

/**
 * 其实 Cglib 创建有构造函数的 Bean 也非常方便，在这里我们更加简化的处理
 * 了，如果你阅读 Spring 源码还会看到 CallbackFilter 等实现，不过我们目前的方
 * 式并不会影响创建。
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }

}
