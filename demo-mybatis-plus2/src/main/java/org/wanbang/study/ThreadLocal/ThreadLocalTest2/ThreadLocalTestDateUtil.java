package org.wanbang.study.ThreadLocal.ThreadLocalTest2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// https://cloud.tencent.com/developer/article/1442006
public class ThreadLocalTestDateUtil {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            service.execute(()->{
                System.out.println(DateUtil.parse("2019-06-01 16:34:30"));
            });
        }
        service.shutdown();
    }
}
