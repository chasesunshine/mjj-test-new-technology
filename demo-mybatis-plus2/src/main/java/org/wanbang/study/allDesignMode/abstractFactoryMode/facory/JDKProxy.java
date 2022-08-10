package org.wanbang.study.allDesignMode.abstractFactoryMode.facory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:22
* @version 1.0
*/

public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
