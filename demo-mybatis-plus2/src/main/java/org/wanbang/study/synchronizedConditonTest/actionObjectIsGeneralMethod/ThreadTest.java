package org.wanbang.study.synchronizedConditonTest.actionObjectIsGeneralMethod;

/**
 * @author yedashi
 * @version 1.0
 * @date 2022/5/16 11:34
 *
 * @description ：4.2同步普通方法
 *               使用Synchronize修饰普通方法时，其作用域是整个方法，锁住的对象是当前对象：
 *
 */
public class ThreadTest {

    public void testSynchronizedMethod() {
        SynchronizedUsage s5 = new SynchronizedUsage();
        SynchronizedUsage s6 = new SynchronizedUsage();
        Thread thread7 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s5.synchronizedMethod1();
            s5.synchronizedMethod2();
            s5.unsafeMethod();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
//        thread7.setName("庚线程");
        thread7.setName("X线程");
        thread7.start();

        Thread thread8 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s5.unsafeMethod();
            s5.synchronizedMethod1();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
//        thread8.setName("辛线程");
        thread8.setName("Y线程");
        thread8.start();

        Thread thread9 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            s6.synchronizedMethod1();
            System.out.println(Thread.currentThread().getName() + "结束");
        });
//        thread9.setName("壬线程");
        thread9.setName("Z线程");
        thread9.start();
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.testSynchronizedMethod();
    }


    /**
     * 结论:
     *      一个线程访问同一个对象的两个不同的同步方法，因为是同一个对象，synchronize方法加锁指向的this也是指向同一个（当前对象），所以会导致程序串行的执行（庚线程方法1、方法2串行执行）；
     *       两个线程访问同一个对象的同步方法，争抢同一把锁，只有一个线程能拿到锁去执行，所以辛线程只能等到庚线程执行完方法1把锁释放之后，才能执行方法1；
     *       两个线程访问两个对象的同步方法，synchronize锁的是不同的对象实例，所以两个线程不会产生互斥，并行的执行代码；
     *       同时访问同步方法和非同步方法，非同步方法不会受到影响。
     */

    /**
     * 执行结果:
     *          庚线程启动
     *          庚线程同步方法1
     *          辛线程启动
     *          壬线程启动
     *          壬线程同步方法1
     *          壬线程同步方法1
     *          庚线程同步方法1
     *          庚线程同步方法1
     *          壬线程同步方法1
     *          辛线程普通方法
     *          壬线程结束
     *          辛线程普通方法
     *          辛线程普通方法
     *          庚线程同步方法2
     *          庚线程同步方法2
     *          庚线程同步方法2
     *          庚线程普通方法
     *          庚线程普通方法
     *          庚线程普通方法
     *          辛线程同步方法1
     *          庚线程结束
     *          辛线程同步方法1
     *          辛线程同步方法1
     *          辛线程结束
     */

}
