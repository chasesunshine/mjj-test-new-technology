package org.wanbang.study.copyAll.quoteCopy.test;

import org.wanbang.study.copyAll.objectCopy.Teacher;

// 对象拷贝
// 创建对象本身的一个副本。
public class ObjectCopyTest {
    // 结果分析：由输出结果可以看出，它们的地址是不同的，
    // 也就是说创建了新的对象， 而不是把原对象的地址赋给了一个新的引用变量,这就叫做对象拷贝。
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("riemann", 28);
        Teacher otherTeacher = (Teacher) teacher.clone();
        System.out.println(teacher);
        System.out.println(otherTeacher);
    }
}
