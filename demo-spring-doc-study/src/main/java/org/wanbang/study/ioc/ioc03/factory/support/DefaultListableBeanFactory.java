package org.wanbang.study.ioc.ioc03.factory.support;

import org.wanbang.study.ioc.ioc03.exception.BeansException;
import org.wanbang.study.ioc.ioc03.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:35
* @version 1.0
*/

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException
    {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }
}
