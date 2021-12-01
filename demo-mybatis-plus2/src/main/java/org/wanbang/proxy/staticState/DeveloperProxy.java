package org.wanbang.proxy.staticState;

import org.wanbang.proxy.common.IDeveloper;

public class DeveloperProxy implements IDeveloper{
    private IDeveloper developer;
    public DeveloperProxy(IDeveloper developer){
        this.developer = developer;
    }
    @Override
    public void writeCode() {
        System.out.println(" 静态代理 : Write documentation...");
        this.developer.writeCode();
    }
}
