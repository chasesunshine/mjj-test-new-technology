package org.wanbang.study.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnginnerCGLibProxy {
    Object obj;

    public Object bind(final Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Cglib代理 : Enginner 2 writes document");
                Object res = method.invoke(target, args);
                return res;
            }
        };
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
