package org.wanbang.study.ThreadLocal.ThreadLocalTest2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// https://cloud.tencent.com/developer/article/1442006
public class TestNumUtilThreadLocal {
    //  什么鬼，不是加10么，怎么都输出了28？
    //  这主要是因为线程切换的原因，线程陆续将addNum值设置为0 ，3，7
    //  但是都没有执行完（没有执行到return addNum+10这一步）就被切换了，
    //  当其中一个线程将addNum值设置为18时，线程陆续开始执行addNum+10这一步，结果都输出了28。
    //  SimpleDateFormat的原因和这个类似，那么我们如何解决这个问题呢？
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(()->{
                System.out.println(num + " " +  NumUtilThreadLocal.add10(num));
            });
        }
        service.shutdown();
    }
}
