package org.wanbang.study.allDesignMode.constructMode.decorateMode;

import org.wanbang.study.allDesignMode.constructMode.decorateMode.common.SsoInterceptor;
import org.wanbang.study.allDesignMode.constructMode.decorateMode.design.LoginSsoDecorator;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/12 16:00
 * @version 1.0
 */

public class Test {

    public static void main(String[] args) {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放⾏" : " 拦 截"));
    }

}
