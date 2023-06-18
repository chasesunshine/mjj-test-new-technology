package org.dongfu.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

// 异步执行代码
@Service("asyncExecutorTest")
public class AsyncExecutorTest {

    // 异步执行的方法, 注解内为自定义线程池类名
    @Async("localBootAsyncExecutor")
    public Future<Integer> test1(Integer i) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("@Async 执行: " + i);
        return new AsyncResult(i);
    }

    // 这里使用其它方式调用，详见后面的 service3 方法
    public Integer test2(Integer i) throws InterruptedException {
        Thread.sleep(100);
        System.out.println(" excute.run 执行: " + i);
        return i;
    }
}
