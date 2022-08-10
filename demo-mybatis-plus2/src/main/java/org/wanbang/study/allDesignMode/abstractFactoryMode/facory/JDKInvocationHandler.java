package org.wanbang.study.allDesignMode.abstractFactoryMode.facory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:22
* @version 1.0
*/

public class JDKInvocationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;
    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = args[i].getClass();
        }

        return ICacheAdapter.class.getMethod(method.getName(), argsClass).invoke(cacheAdapter, args);
    }
}
