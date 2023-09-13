package org.dongfu.study.ioc.ioc09.context.support;
/**
* @description: 包装处理器(ApplicationContextAwareProcessor)
* @author majiajian
* @date 2022/10/26 16:42
* @version 1.0
*/

import org.dongfu.study.ioc.ioc09.context.ApplicationContext;
import org.dongfu.study.ioc.ioc09.context.ApplicationContextAware;
import org.dongfu.study.ioc.ioc09.exception.BeansException;
import org.dongfu.study.ioc.ioc09.factory.config.BeanPostProcessor;

/**
 *  由于 ApplicationContext 的获取并不能直接在创建 Bean 时候就可以拿到，所以
 * 需要在 refresh 操作时，把 ApplicationContext 写入到一个包装的
 * BeanPostProcessor 中去，再由AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization
 * 方法调用。
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;
    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

