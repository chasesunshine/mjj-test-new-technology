package org.wanbang.study.synchronizedConditonTest.actionObjectIsObject;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:34
 *
 * @description ：2、作用对象为对象
 *               在SynchronizedUsage中添加2个方法，一个锁住当前对象，另一个锁住其他对象
 *
 */
public class ThreadTest {

    public void testSynchronizedCodelockObjct() {
        SynchronizedUsage s3 = new SynchronizedUsage();
        SynchronizedUsage s4 = new SynchronizedUsage();

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s3.synchronizedCodelockObjct();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread3.setName("丙线程");
        thread3.start();

        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s3.synchronizedCodelockObjct();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread4.setName("丁线程");
        thread4.start();




        Thread thread5 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s4.synchronizedCodelockObjct();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread5.setName("戊线程");
        thread5.start();



        Thread thread6 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s3.synchronizedCodelockObjct2();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
        thread6.setName("己线程");
        thread6.start();
    }


    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        //test.testSynchronizedCodelockClass();
        test.testSynchronizedCodelockObjct();
    }

    /**
     * 结论：
     *      丙线程和丁线程锁的是同一个对象s3，所以它们不能并发运行print方法；
     *      戊线程作用的是另一个对象s4，因此它可以跟丙线程并发运行；
     *      己线程虽然也是调用对象s3，但它锁住的对象是obj，跟丙、丁锁的对象不一致，所以它也可以跟戊、丙线程并发运行。
     *
     */

    /**
     * 执行结果:
     *        丙线程启动
     *        Hello 丙线程
     *        丁线程启动
     *        戊线程启动
     *        己线程启动
     *        锁的是object对象
     *        Hello 己线程
     *        Hello 戊线程
     *        Hello 丙线程
     *        Hello 己线程
     *        Hello 戊线程
     *        Hello 丙线程
     *        Hello 戊线程
     *        Hello 己线程
     *        Hello 丙线程
     *        Hello 己线程
     *        Hello 戊线程
     *        Hello 丙线程
     *        Hello 己线程
     *        Hello 戊线程
     *        Hello 丁线程
     *        丙线程结束
     *        戊线程结束
     *        己线程结束
     *        Hello 丁线程
     *        Hello 丁线程
     *        Hello 丁线程
     *        Hello 丁线程
     *        丁线程结束
     */
}
