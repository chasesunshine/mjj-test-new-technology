package org.wanbang.study.ioc.ioc06.factory.support;

import org.wanbang.study.ioc.ioc06.core.io.Resource;
import org.wanbang.study.ioc.ioc06.core.io.ResourceLoader;
import org.wanbang.study.ioc.ioc06.exception.BeansException;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:06
* @version 1.0
*/

/**
 *  这是一个 Simple interface for bean definition readers. 其实里面无非定义了几个方
 * 法，包括：getRegistry()、getResourceLoader()，以及三个加载 Bean 定义的方法。
 *  这里需要注意 getRegistry()、getResourceLoader()，都是用于提供给后面三个方法
 * 的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口
 * 实现方法。
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();
    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;

}
