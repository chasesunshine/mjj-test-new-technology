package org.wanbang.study.springPostConstruct.entity;

import org.springframework.stereotype.Component;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/13 17:45
* @version 1.0
*/

@Component
public class B {
    public B(){
        System.out.println("执行B的构造方法");
    }
}
