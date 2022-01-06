package org.wanbang.study.ThreadLocal.ThreadLocalTest2;

import java.util.concurrent.TimeUnit;

public class NumUtil {
    public static int addNum = 0;

    public static int add10(int num) {
        addNum = num;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum + 10;
    }
}
