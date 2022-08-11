package org.wanbang.study.allDesignMode.abstractFactoryMode.facory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:22
* @version 1.0
*/

/**
 * 这⾥主要的作⽤就是完成代理类，同时对于使⽤哪个集群有外部通过⼊参进⾏传递。
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
