package org.wanbang.proxy;

import org.wanbang.proxy.common.ProductOwner;
import org.wanbang.proxy.dynamic.cglib.EnginnerCGLibProxy;

public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        ProductOwner ross = new ProductOwner("Ross");
        ProductOwner rossProxy = (ProductOwner) new EnginnerCGLibProxy().bind(ross);
        rossProxy.defineBackLog();
    }
}
