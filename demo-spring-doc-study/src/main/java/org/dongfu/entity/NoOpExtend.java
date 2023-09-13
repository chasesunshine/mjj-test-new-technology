package org.dongfu.entity;

import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/14 10:57
* @version 1.0
*/

public interface NoOpExtend extends NoOp {
    Object intercept(Object var1, Method var2, Object[] var3, MethodProxy var4) throws Throwable;
}
