package org.wanbang.study.allDesignMode.createMode.proxyMode;

import org.wanbang.study.allDesignMode.createMode.proxyMode.handler.DynamicProxy;
import org.wanbang.study.allDesignMode.createMode.proxyMode.service.Subject;
import org.wanbang.study.allDesignMode.createMode.proxyMode.service.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 11:32
* @version 1.0
*/

public class Client {
    public static void main(String[] args) {
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();
        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过  该真实对象  来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        ClassLoader classLoader = handler.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println(subject.getClass().getName()); // com.sun.proxy.$Proxy0
        subject.rent();
        subject.hello("world");
    }
}
