package org.dongfu.study.synchronizedConditonTest.actionObjectIsStaticMethod;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:34
 *
 * @description ：4.3同步静态方法
 *               作用域是整个方法，锁住的是当前类及该类的所有对象，其效果等效于在同步代码块中锁住类对象：
 *
 */
public class ThreadTest {

    public void testSynchronizedStaticMethod() {
        SynchronizedUsage su = new SynchronizedUsage();

        Thread thread10 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            SynchronizedUsage.synchronizedStaticmethod();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread10.setName("癸线程");
        thread10.start();

        Thread thread11 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            SynchronizedUsage.synchronizedStaticmethod();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread11.setName("子线程");
        thread11.start();

        Thread thread12 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            SynchronizedUsage.synchronizedStaticmethod();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread12.setName("马线程");
        thread12.start();
    }


    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.testSynchronizedStaticMethod();
    }

    /**
     * 结论：
     *      作用域是整个方法，锁住的是当前类及该类的所有对象，其效果等效于在同步代码块中锁住类对象：
     */

    /**
     * 执行结果:
     *          癸线程启动
     *          子线程启动
     *          癸线程同步静态方法1
     *          癸线程同步静态方法1
     *          癸线程同步静态方法1
     *          子线程同步静态方法1
     *          癸线程结束
     *          子线程同步静态方法1
     *          子线程同步静态方法1
     *          子线程结束
     */
}
