package org.dongfu.study.synchronizedFourCondition.method;

// Synchronized修饰一个方法很简单，就是在方法的前面加synchronized，public synchronized void method(){};
// synchronized修饰方法和修饰一个代码块类似，只是作用范围不一样，修饰代码块是大括号括起来的范围，而修饰方法范围是整个函数。
// 如将的run方法改成如下的方式，实现的效果一样。
public class SyncThread implements Runnable {
    // static跟着类走，所以有影响，如果不加，那么就不会叠加
    private static int count;
    public SyncThread() {
        count = 0;
    }
    public synchronized void run() {
        //synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //}
    }

    // Synchronized作用于整个方法的写法
    // 写法一:
    public synchronized void method1() {
        // todo
    }

    // 写法二:
    public void method2() {
        synchronized(this) {
            // todo
        }
    }

    //1. synchronized关键字不能继承。
    //虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
    // 因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，
    // 而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个方法中加上synchronized关键字才可以。
    // 当然，还可以在子类方法中调用父类中相应的方法，这样虽然子类中的方法不是同步的，但子类调用了父类的同步方法，
    // 因此，子类的方法也就相当于同步了.

}