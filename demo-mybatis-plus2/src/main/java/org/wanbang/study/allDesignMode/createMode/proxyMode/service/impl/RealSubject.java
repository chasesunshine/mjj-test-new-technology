package org.wanbang.study.allDesignMode.createMode.proxyMode.service.impl;

import org.wanbang.study.allDesignMode.createMode.proxyMode.service.Subject;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 11:31
* @version 1.0
*/

public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
