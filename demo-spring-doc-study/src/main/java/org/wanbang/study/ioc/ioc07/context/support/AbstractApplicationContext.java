package org.wanbang.study.ioc.ioc07.context.support;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:28
* @version 1.0
*/

import org.wanbang.study.ioc.ioc07.context.ConfigurableApplicationContext;
import org.wanbang.study.ioc.ioc07.core.io.DefaultResourceLoader;
import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.ConfigurableListableBeanFactory;
import org.wanbang.study.ioc.ioc07.factory.config.BeanFactoryPostProcessor;
import org.wanbang.study.ioc.ioc07.factory.config.BeanPostProcessor;

import java.util.Map;

/**
 *
 *  AbstractApplicationContext 继承 DefaultResourceLoader 是为了处理
 * spring.xml 配置资源的加载。
 *  之后是在 refresh() 定义实现过程，包括：
 * 
 * 1. 创建 BeanFactory，并加载 BeanDefinition
 * 
 * 2. 获取 BeanFactory
 * 
 * 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke
 * factory processors registered as beans in the context.)
 * 
 * 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注
 * 册操作
 * 
 * 5. 提前实例化单例 Bean 对象
 *  另外把定义出来的抽象方法，refreshBeanFactory()、getBeanFactory() 由后面的继
 * 承此抽象类的其他抽象类实现。
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
// 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
// 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
// 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
// 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
// 5. 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();
    }
    protected abstract void refreshBeanFactory() throws BeansException;
    protected abstract ConfigurableListableBeanFactory getBeanFactory();
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }
//... getBean、getBeansOfType、getBeanDefinitionNames 方法
}