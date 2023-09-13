package org.dongfu.util.proxy;

import org.springframework.aop.framework.AopContext;

/**
 * @author mjj
 * @date 2022/08/01
 */
public class CurrentProxy {
    public static final <T> T currentProxyByAop(Class<T> proxy) {
        return (T) AopContext.currentProxy();
    }
}
