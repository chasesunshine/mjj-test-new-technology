package org.dongfu.study.ioc.ioc09.context.support;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:29
* @version 1.0
*/

import org.dongfu.study.ioc.ioc09.factory.support.DefaultListableBeanFactory;
import org.dongfu.study.ioc.ioc09.factory.support2.XmlBeanDefinitionReader;

/**
 *
 *  在 AbstractXmlApplicationContext 抽象类的 loadBeanDefinitions 方法实现中，使
 * 用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作。
 *  同时这里又留下了一个抽象类方法，getConfigLocations()，此方法是为了从入口上
 * 下文类，拿到配置信息的地址描述。
 *
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
