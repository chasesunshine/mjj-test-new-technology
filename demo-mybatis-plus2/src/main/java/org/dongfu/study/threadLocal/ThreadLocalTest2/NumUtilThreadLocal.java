package org.dongfu.study.threadLocal.ThreadLocalTest2;

import java.util.concurrent.TimeUnit;

public class NumUtilThreadLocal {
    private static ThreadLocal<Integer> addNumThreadLocal = new ThreadLocal<>();

    public static int add10(int num) {
        addNumThreadLocal.set(num);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNumThreadLocal.get() + 10;
    }
}
