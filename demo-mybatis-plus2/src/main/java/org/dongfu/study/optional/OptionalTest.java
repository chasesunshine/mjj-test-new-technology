package org.dongfu.study.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }


    /**
     * 创建Optional类
     */
    public static void test1() {
        // 声明一个空Optional
        Optional<Object> empty = Optional.empty();

        // 依据一个非空值创建Optional
        Student student = new Student();
        Optional<Student> os1 = Optional.of(student);

        // 可接受null的Optional
        Student student1 = null;
        Optional<Student> os2 = Optional.ofNullable(student1);

        System.out.println(os1.isPresent());
        System.out.println(os1.get());
        System.out.println(os2.isPresent());
        System.out.println(os2.get());
    }

    /**
     * 判断Optional容器中是否包含对象
     *
     * isPresent不带参数，判断是否为空，
     * ifPresent可以选择带一个消费函数的实例。（isPresent和ifPresent一个是 is 一个是 if 注意一下哈）
     */
    public static void test2() {
        Student student = new Student();
        Optional<Student> os1 = Optional.ofNullable(student);
        boolean present = os1.isPresent();
        System.out.println(present);
        System.out.println(student);

        // 利用Optional的ifPresent方法做出如下：当student不为空的时候将name赋值为张三
        Optional.ofNullable(student).ifPresent(p -> p.setName("张三"));
        System.out.println(student);
    }

    /**
     * 获取Optional容器的对象
     *
     * @throws Exception
     */
    public static void test3() throws Exception {
        Student student = null;
        Optional<Student> os1 = Optional.ofNullable(student);
        // 使用get一定要注意，假如student对象为空，get是会报错的
        // java.util.NoSuchElementException: No value present
        Student student1 = os1.get();
        System.out.println(student1);

        // 当student为空的时候,返回我们新建的这个对象,有点像三目运算的感觉
        Student student2 = os1.orElse(new Student("张三", 18));
        System.out.println(student2);

        // orElseGet就是当student为空的时候，返回通过Supplier供应商函数创建的对象
        Student student3 = os1.orElseGet(() -> new Student("张三", 18));
        System.out.println(student3);

        // orElseThrow就是当student为空的时候，可以抛出我们指定的异常
        os1.orElseThrow(() -> new Exception());
    }

    /**
     * 过滤
     */
    public static void test4() {
        Student student = new Student("李四", 3);
        Optional<Student> os1 = Optional.ofNullable(student);
        os1.filter(p -> p.getName().equals("张三")).ifPresent(x -> System.out.println("OK"));
//        os1.filter(p -> p.getName().equals("李四")).ifPresent(x -> System.out.println("OK"));
        System.out.println(os1.get());
    }

    /**
     * 映射
     */
    public static void test5() {
        Student student = new Student("李四", 3);
        Optional<Student> os1 = Optional.ofNullable(student);
        // 如果student对象不为空，就加一岁
        Optional<Student> emp = os1.map(e -> {
            e.setAge(e.getAge() + 1);
            return e;
        });

        System.out.println(emp.get());
    }

}
