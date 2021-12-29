package org.wanbang.study.proxy;

import org.wanbang.study.proxy.common.IDeveloper;
import org.wanbang.study.proxy.common.ITester;
import org.wanbang.study.proxy.common.impl.Developer;
import org.wanbang.study.proxy.common.impl.Tester;
import org.wanbang.study.proxy.staticState.DeveloperProxy;
import org.wanbang.study.proxy.staticState.TesterProxy;

public class StaticStateProxyTest {
    public static void main(String[] args) {
        IDeveloper jerry = new Developer("Jerry");
        jerry.writeCode();
        ITester sara = new Tester("Sara");
        sara.doTesting();;

        System.out.println("----------------------------------------------------");
        // 静态代理
        DeveloperProxy developerProxy = new DeveloperProxy(jerry);
        developerProxy.writeCode();

        TesterProxy testerProxy = new TesterProxy(sara);
        testerProxy.doTesting();
    }
}
