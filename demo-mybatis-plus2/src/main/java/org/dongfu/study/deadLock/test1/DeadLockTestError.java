package org.dongfu.study.deadLock.test1;

// 思路是创建两个字符串a和b，再创建两个线程A和B，让每个线程都用synchronized锁住字符串
// （A先锁a，再去锁b；B先锁b，再锁a），如果A锁住a，B锁住b，A就没办法锁住b，B也没办法锁住a，这时就陷入了死锁。直接贴代码：

// 可以看到，Lock1获取obj1，Lock2获取obj2，但是它们都没有办法再获取另外一个obj，因为它们都在等待对方先释放锁，这时就是死锁。
public class DeadLockTestError {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}

