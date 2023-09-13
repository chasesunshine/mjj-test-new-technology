package org.dongfu.study.proxy;

import org.dongfu.study.proxy.common.ProductOwner;
import org.dongfu.study.proxy.dynamic.cglib.EnginnerCGLibProxy;

public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        ProductOwner ross = new ProductOwner("Ross");
        ProductOwner rossProxy = (ProductOwner) new EnginnerCGLibProxy().bind(ross);
//        ProductOwner rossProxy = (ProductOwner) new EnginnerCGLibProxy().bind1(ross);
        rossProxy.defineBackLog();
    }
}
