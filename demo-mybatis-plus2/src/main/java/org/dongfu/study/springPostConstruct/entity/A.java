package org.dongfu.study.springPostConstruct.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/13 17:44
* @version 1.0
*/


@Component
public class A {

    @Autowired
    private B b;

    public A() {
        System.out.println("执行A的构造方法，此时b还未被注入: b = " + b);
    }

    @PostConstruct
    private void init() {
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
    }
}