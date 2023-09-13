package org.dongfu.study.allDesignMode.createMode.proxyMode.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 11:32
* @version 1.0
*/

public class DynamicProxy implements InvocationHandler {
    //　这个就是我们要代理的真实对象
    private Object subject;
    private Integer count = 0;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable{
        count = count + 1;
        System.out.println("\n 调用次数 : " + count );
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");

        System.out.println("Method:" + method);

        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);

        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");

        System.out.println("\n");
        return null;
    }
}
