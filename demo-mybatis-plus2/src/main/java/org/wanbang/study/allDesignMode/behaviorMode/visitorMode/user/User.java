package org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user;

import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.visitor.Visitor;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:32
* @version 1.0
*/

// 基础⽤户信息
public abstract class User {
    public String name; // 姓名
    public String identity; // 身份；᯿点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz; // 班级

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }
    // 核⼼访问⽅法
    public abstract void accept(Visitor visitor);
}
