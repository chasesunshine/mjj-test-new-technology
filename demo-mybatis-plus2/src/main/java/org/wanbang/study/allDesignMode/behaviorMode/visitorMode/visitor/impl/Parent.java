package org.wanbang.study.allDesignMode.behaviorMode.visitorMode.visitor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user.impl.Student;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user.impl.Teacher;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.visitor.Visitor;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:33
* @version 1.0
*/

public class Parent implements Visitor {
    private Logger logger = LoggerFactory.getLogger(Parent.class);

    public void visit(Student student) {
        logger.info("学⽣信息 姓名：{} 班级：{} 排名：{}", student.name, student.clazz, student.ranking());
    }

    public void visit(Teacher teacher) {
        logger.info("⽼师信息 姓名：{} 班级：{} 级别：{}", teacher.name,
                teacher.clazz, teacher.identity);
    }

}
