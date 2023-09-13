package org.dongfu.study.ioc.ioc10.factory.support;

import lombok.extern.slf4j.Slf4j;
import org.dongfu.study.ioc.ioc10.exception.BeansException;
import org.dongfu.study.ioc.ioc10.factory.FactoryBean;
import org.dongfu.study.ioc.ioc10.factory.config.BeanPostProcessor;
import org.dongfu.study.ioc.ioc10.factory.config.ConfigurableBeanFactory;
import org.dongfu.study.ioc.ioc10.factory.config.BeanDefinition;
import org.dongfu.study.ioc.ioc10.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

/**
 *  AbstractBeanFactory 首先继承了 DefaultSingletonBeanRegistry，也就具备了使用
 * 单例注册类方法。
 *  接下来很重要的一点是关于接口 BeanFactory 的实现，在方法 getBean 的实现过
 * 程中可以看到，主要是对单例 Bean 对象的获取以及在获取不到时需要拿到 Bean
 * 的定义做相应 Bean 实例化操作。那么 getBean 并没有自身的去实现这些方法，
 * 而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实
 * 现。
 *  后续继承抽象类 AbstractBeanFactory 的类有两个，包括：
 * AbstractAutowireCapableBeanFactory、DefaultListableBeanFactory，这两个类分别
 * 做了相应的实现处理，接着往下看。
 *
 *  首先这里把 AbstractBeanFactory 原来继承的 DefaultSingletonBeanRegistry，修改
 * 为继承 FactoryBeanRegistrySupport。因为需要扩展出创建 FactoryBean 对象的能
 * 力，所以这就想一个链条服务上，截出一个段来处理额外的服务，并把链条再链接
 * 上。
 *  此处新增加的功能主要是在 doGetBean 方法中，添加了调用 (T)
 * getObjectForBeanInstance(sharedInstance, name) 对获取
 * FactoryBean 的操作。
 *  在 getObjectForBeanInstance 方法中做具体的 instanceof 判断，另外还会从
 * FactoryBean 的缓存中获取对象，如果不存在则调用
 * FactoryBeanRegistrySupport#getObjectFromFactoryBean，执行具体的操作。
 */
@Slf4j
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
        // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);

    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}