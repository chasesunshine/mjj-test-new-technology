package org.wanbang.study.ioc.ioc10.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.wanbang.study.ioc.ioc10.entity.PropertyValue;
import org.wanbang.study.ioc.ioc10.entity.PropertyValues;
import org.wanbang.study.ioc.ioc10.exception.BeansException;
import org.wanbang.study.ioc.ioc10.factory.*;
import org.wanbang.study.ioc.ioc10.factory.config.AutowireCapableBeanFactory;
import org.wanbang.study.ioc.ioc10.factory.config.BeanPostProcessor;
import org.wanbang.study.ioc.ioc10.factory.config.BeanReference;
import org.wanbang.study.ioc.ioc10.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description: 创建 Bean 时注册销毁方法对象
 * @author majiajian
 * @date 2022/9/7 18:15
 * @version 1.0
 */

/**
 *  这个类的内容稍微有点长，主要包括三个方法：createBean、createBeanInstance、
 * applyPropertyValues，这里我们主要关注 createBean 的方法中调用的
 * applyPropertyValues 方法。
 *  在 applyPropertyValues 中，通过获取
 * beanDefinition.getPropertyValues() 循环进行属性填充操作，如果遇
 * 到的是 BeanReference，那么就需要递归获取 Bean 实例，调用 getBean 方法。
 *  当把依赖的 Bean 对象创建完成后，会递归回现在属性填充中。这里需要注意我们
 * 并没有去处理循环依赖的问题，这部分内容较大，后续补充。
 * BeanUtil.setFieldValue(bean, name, value) 是 hutool-all 工具类中的方法，你也可
 * 以自己实现
 *
 *  抽象类 AbstractAutowireCapableBeanFactory 中的 createBean 是用来创建 Bean
 * 对象的方法，在这个方法中我们之前已经扩展了 BeanFactoryPostProcessor、
 * BeanPostProcessor 操作，这里我们继续完善执行 Bean 对象的初始化方法的处理
 * 动作。
 *  在方法 invokeInitMethods 中，主要分为两块来执行实现了 InitializingBean 接口
 * 的操作，处理 afterPropertiesSet 方法。另外一个是判断配置信息 init-method 是
 * 否存在，执行反射调用 initMethod.invoke(bean)。这两种方式都可以在 Bean 对象
 * 初始化过程中进行处理加载 Bean 对象中的初始化操作，让使用者可以额外新增加
 * 自己想要的动作。
 *
 *  在创建 Bean 对象的实例的时候，需要把销毁方法保存起来，方便后续执行销毁动
 * 作进行调用。
 *  那么这个销毁方法的具体方法信息，会被注册到 DefaultSingletonBeanRegistry 中
 * 新增加的 Map<String, DisposableBean> disposableBeans 属性中
 * 去，因为这个接口的方法最终可以被类 AbstractApplicationContext 的 close 方法
 * 通过 getBeanFactory().destroySingletons() 调用。
 *  在注册销毁方法的时候，会根据是接口类型和配置类型统一交给
 * DisposableBeanAdapter 销毁适配器类来做统一处理。实现了某个接口的类可以被
 * instanceof 判断或者强转后调用接口方法
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        addSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // invokeAwareMethods
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware){
                ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }

        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 执行 Bean 对象的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口 InitializingBean
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        // 2. 注解配置 init-method {判断是为了避免二次执行初始化}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }


    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

}