package org.wanbang.study.proxy.entity;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/14 10:57
* @version 1.0
*/

public interface NoOpExtend extends MethodInterceptor {
}
