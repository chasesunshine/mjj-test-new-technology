package org.wanbang.study.ioc.step01.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description: 2. BeanFactory，代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
* @author majiajian
* @date 2022/9/2 15:47
* @version 1.0
*/

/**
 * 在 Bean 工厂的实现中，包括了 Bean 的注册，这里注册的是 Bean 的定义信
 * 息。同时在这个类中还包括了获取 Bean 的操作。
 *
 * 目前的 BeanFactory 仍然是非常简化的实现，但这种简化的实现内容也是整个
 * Spring 容器中关于 Bean 使用的最终体现结果，只不过实现过程只展示出基本的
 * 核心原理。在后续的补充实现中，这个会不断变得庞大。
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}

