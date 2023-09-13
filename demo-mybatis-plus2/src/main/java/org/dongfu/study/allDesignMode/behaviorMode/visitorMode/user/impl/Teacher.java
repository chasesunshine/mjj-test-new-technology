package org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.impl;

import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.User;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.visitor.Visitor;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:32
* @version 1.0
*/

public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // 升本率
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
