package org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.User;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.visitor.Visitor;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:32
* @version 1.0
*/
public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }

}
