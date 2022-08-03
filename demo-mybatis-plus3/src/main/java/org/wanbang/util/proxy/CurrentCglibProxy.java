package org.wanbang.util.proxy;

import org.springframework.aop.framework.AopContext;

/**
 * @author mjj
 * @date 2022/08/01
 */
public class CurrentCglibProxy {
    public static final <T> T currentProxyByCglib(Class<T> proxy) {
        return (T) AopContext.currentProxy();
    }
}
