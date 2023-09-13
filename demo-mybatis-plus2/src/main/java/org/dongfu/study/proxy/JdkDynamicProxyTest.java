package org.dongfu.study.proxy;

import org.dongfu.study.proxy.common.ProductOwner;
import org.dongfu.study.proxy.dynamic.jdk.EnginnerProxy;
import org.dongfu.study.proxy.common.IDeveloper;
import org.dongfu.study.proxy.common.ITester;
import org.dongfu.study.proxy.common.impl.Developer;
import org.dongfu.study.proxy.common.impl.Tester;

public class JdkDynamicProxyTest {
    public static void main(String[] args) {
        IDeveloper jerry = new Developer("Jerry");
        jerry.writeCode();
        ITester sara = new Tester("Sara");
        sara.doTesting();;

        System.out.println(" JDK动态代理 ----------------------------------------------------");
        // JDK动态代理
        IDeveloper jerryProxy = (IDeveloper) new EnginnerProxy().bind(jerry);
        jerryProxy.writeCode();

        ITester saraProxy = (ITester) new EnginnerProxy().bind(sara);
        saraProxy.doTesting();

        System.out.println(" 错误JDK动态代理（没有实现任何接口） ----------------------------------------------------");
        // 错误JDK动态代理（没有实现任何接口）
        // 运行时报错。所以局限性就是：如果被代理的类未实现任何接口，那么不能采用通过InvocationHandler动态代理的方式去代理它的行为。
        ProductOwner po = new ProductOwner("Ross");
        ProductOwner poProxy = (ProductOwner) new EnginnerProxy().bind(po);
        poProxy.defineBackLog();
    }
}
