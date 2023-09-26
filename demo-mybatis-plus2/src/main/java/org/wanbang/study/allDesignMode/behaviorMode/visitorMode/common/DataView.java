package org.wanbang.study.allDesignMode.behaviorMode.visitorMode.common;

import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user.User;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user.impl.Student;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.user.impl.Teacher;
import org.wanbang.study.allDesignMode.behaviorMode.visitorMode.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:33
* @version 1.0
*/

public class DataView {
    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢⻜机", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("windy", "᯿点班", "⼀年⼀班"));
        userList.add(new Student("⼤⽑", "普通班", "⼆年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "⼀年⼀班"));
        userList.add(new Teacher("dangdang", "普通教师", "⼆年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    // 展示
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

}
