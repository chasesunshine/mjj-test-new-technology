package org.wanbang.study.copyAll.quoteCopy.test;

import org.wanbang.study.copyAll.quoteCopy.Teacher;

// 引用拷贝
// 创建一个指向对象的引用变量的拷贝。
public class QuoteCopyTest {
    // 结果分析：由输出结果可以看出，它们的地址值是相同的，那么它们肯定是同一个对象。
    // teacher和otherTeacher的只是引用而已，他们都指向了一个相同的对象Teacher(“riemann”,28)。 这就叫做引用拷贝。
    public static void main(String[] args) {
        Teacher teacher = new Teacher("riemann", 28);
        Teacher otherTeacher = teacher;
        System.out.println(teacher);
        System.out.println(otherTeacher);
    }
}
