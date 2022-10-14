package org.wanbang.study.ioc.ioc08.context;

import org.wanbang.study.ioc.ioc08.exception.BeansException; /**
* @description: TODO
* @author majiajian
* @date 2022/10/9 18:28
* @version 1.0
*/

/**
 *
 *  ConfigurableApplicationContext 继承自 ApplicationContext，并提供了 refresh 这
 * 个核心方法。如果你有看过一些 Spring 源码，那么一定会看到这个方法。 接下
 * 来也是需要在上下文的实现中完成刷新容器的操作过程。
 *
 *  首先我们需要在 ConfigurableApplicationContext 接口中定义注册虚拟机钩子的方
 * 法 registerShutdownHook 和手动执行关闭的方法 close。
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}

