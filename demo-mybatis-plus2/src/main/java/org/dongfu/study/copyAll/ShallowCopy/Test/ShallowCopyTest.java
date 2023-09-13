package org.dongfu.study.copyAll.ShallowCopy.Test;


import org.dongfu.study.copyAll.ShallowCopy.Student;
import org.dongfu.study.copyAll.ShallowCopy.Teacher;

// 浅拷贝
// 被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
// 即对象的浅拷贝会对“主”对象进行拷贝，但不会复制主对象里面的对象。”里面的对象“会在原来的对象和它的副本之间共享。
// 简而言之，浅拷贝仅仅复制所考虑的对象，而不复制它所引用的对象。
public class ShallowCopyTest {
    // 结果分析： 两个引用student1和student2指向不同的两个对象，
    // 但是两个引用student1和student2中的两个teacher引用指向的是同一个对象，所以说明是浅拷贝。
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("riemann");
        teacher.setAge(28);

        Student student1 = new Student();
        student1.setName("edgar");
        student1.setAge(18);
        student1.setTeacher(teacher);

        Student student2 = (Student) student1.clone();
        System.out.println("-------------拷贝后-------------");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());

        System.out.println("-------------修改老师的信息后-------------");
        // 修改老师的信息
        teacher.setName("jack");
        System.out.println("student1的teacher为： " + student1.getTeacher().getName());
        System.out.println("student2的teacher为： " + student2.getTeacher().getName());

    }
}
