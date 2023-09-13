package org.dongfu.study.ioc.ioc09.context.support;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:28
* @version 1.0
*/

import org.dongfu.study.ioc.ioc09.context.ConfigurableApplicationContext;
import org.dongfu.study.ioc.ioc09.core.io.DefaultResourceLoader;
import org.dongfu.study.ioc.ioc09.exception.BeansException;
import org.dongfu.study.ioc.ioc09.factory.ConfigurableListableBeanFactory;
import org.dongfu.study.ioc.ioc09.factory.config.BeanFactoryPostProcessor;
import org.dongfu.study.ioc.ioc09.factory.config.BeanPostProcessor;

import java.util.Map;

/**
 *
 *  AbstractApplicationContext 继承 DefaultResourceLoader 是为了处理
 * spring07.xml 配置资源的加载。
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
 *
 *  这里主要体现了关于注册钩子和关闭的方法实现，上文提到过的
 * Runtime.getRuntime().addShutdownHook，可以尝试验证。在一些中间
 * 件和监控系统的设计中也可以用得到，比如监测服务器宕机，执行备机启动操作。
 *
 *  refresh() 方法就是整个 Spring 容器的操作过程，与上一章节对比，本次新增加了
 * 关于 addBeanPostProcessor 的操作。
 *  添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的
 * Bean 对象都能感知所属的 ApplicationContext。
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }
    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

}
