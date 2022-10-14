package org.wanbang.study.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.wanbang.study.proxy.entity.NoOpExtend;

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
                // method.invoke(target, args) 这个是动态代理核心
                Object res = method.invoke(target, args);
                return res;
            }
        };
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }


    public Object bind1(final Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());

        NoOpExtend noOpExtend = new NoOpExtend(){
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Cglib代理 : Enginner 2 writes document");
                Object res = method.invoke(target, args);
                return res;
            }
        };

        enhancer.setCallback(noOpExtend);
        return enhancer.create();
    }
}
