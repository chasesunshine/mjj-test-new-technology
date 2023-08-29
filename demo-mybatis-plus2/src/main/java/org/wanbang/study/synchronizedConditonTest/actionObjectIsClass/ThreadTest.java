package org.wanbang.study.synchronizedConditonTest.actionObjectIsClass;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:34
 *
 * @description ： 1、作用对象是类的时候，作用的是类及该类的所有对象
 *
 */
public class ThreadTest {

    /**
     * 同步代码块——类锁测试
     */
    public void testSynchronizedCodelockClass() {
        SynchronizedUsage s1 = new SynchronizedUsage();
        SynchronizedUsage s2 = new SynchronizedUsage();
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s1.synchronizedCodelockClass();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
//        thread1.setName("甲线程");
        thread1.setName("A线程");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s2.synchronizedCodelockClass2();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
//        thread2.setName("乙线程");
        thread2.setName("B线程");
        thread2.start();
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.testSynchronizedCodelockClass();
    }
    /**
     * mjj结论：
     *      锁住的是类的时候，访问这个类里面所有 synchronized 修饰的加锁方法都需等
     *      正在对这个类加锁的线程 使用完释放锁之后 其他线程才可以使用
     */

    /**
     * 结论:
     *     可见，当锁住的是类的时候，虽然多个线程所关联的对象不一样，但这些对象同属SynchronizedUsage，
     *     锁住的代码块只能在当前已获得锁的线程执行完毕之后，
     *     才能由下一个线程去获得锁然后执行代码块。
     *
     */

    /**
     * 执行结果:
     *
     *      甲线程启动
     *      Hello 甲线程
     *      乙线程启动
     *      Hello 甲线程
     *      Hello 甲线程
     *      Hello 甲线程
     *      Hello 甲线程
     *      Hello 乙线程
     *      甲线程结束
     *      Hello 乙线程
     *      Hello 乙线程
     *      Hello 乙线程
     *      Hello 乙线程
     *      乙线程结束
     */
}
