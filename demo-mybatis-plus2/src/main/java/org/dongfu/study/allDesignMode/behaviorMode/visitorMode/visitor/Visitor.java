package org.dongfu.study.allDesignMode.behaviorMode.visitorMode.visitor;

import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.impl.Student;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.user.impl.Teacher;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:33
* @version 1.0
*/

public interface Visitor {

    // 访问学⽣信息
    void visit(Student student);

    // 访问⽼师信息
    void visit(Teacher teacher);

}
