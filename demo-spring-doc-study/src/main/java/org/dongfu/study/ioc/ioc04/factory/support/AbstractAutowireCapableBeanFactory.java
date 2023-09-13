package org.dongfu.study.ioc.ioc04.factory.support;

import org.dongfu.study.ioc.ioc04.exception.BeansException;
import org.dongfu.study.ioc.ioc04.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

/**
 *  首先在 AbstractAutowireCapableBeanFactory 抽象类中定义了一个创建对象的实
 *  例化策略属性类 InstantiationStrategy instantiationStrategy，
 *  这里我们选择了 Cglib 的实现类。
 *  接下来抽取 createBeanInstance 方法，在这个方法中需要注意 Constructor
 *  代表了你有多少个构造函数，通过 beanClass.getDeclaredConstructors() 方式可以
 *  获取到你所有的构造函数，是一个集合。
 *  接下来就需要循环比对出构造函数集合与入参信息 args 的匹配情况，这里我们
 *  对比的方式比较简单，只是一个数量对比，而实际 Spring 源码中还需要比对入参
 *  类型，否则相同数量不同入参类型的情况，就会抛异常了。
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }

}

