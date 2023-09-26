package org.wanbang.study.proxy;

import org.wanbang.study.proxy.common.ProductOwner;
import org.wanbang.study.proxy.dynamic.cglib.EnginnerCGLibProxy;

public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        ProductOwner ross = new ProductOwner("Ross");
        ProductOwner rossProxy = (ProductOwner) new EnginnerCGLibProxy().bind(ross);
//        ProductOwner rossProxy = (ProductOwner) new EnginnerCGLibProxy().bind1(ross);
        rossProxy.defineBackLog();
    }
}
