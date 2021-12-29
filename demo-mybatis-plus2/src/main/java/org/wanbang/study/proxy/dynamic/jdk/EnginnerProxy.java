package org.wanbang.study.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 用的是反射的包 ，通过反射来获取对象
// JDK动态代理
public class EnginnerProxy implements InvocationHandler {
    Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理 反射 : Enginner writes document");
        proxy = obj;
        Object res = method.invoke(proxy, args);
        return res;
    }

}
