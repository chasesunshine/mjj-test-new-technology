package org.dongfu.service;

import org.dongfu.util.AsyncExecutorTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

// 业务 service
@Service("asyncExcutorService")
public class AsyncExcutorService {

    @Autowired
    AsyncExecutorTest asyncExecutorTest;

    @Autowired
    Executor localBootAsyncExecutor;

    // 测试 无返回值异步执行
    public void service1(){
        System.out.println("service1 执行----->");
        for (int i = 0; i < 50; i++) {
            try {
                asyncExecutorTest.test1(i);
            } catch (InterruptedException e) {
                System.out.println("service1执行出错");
            }
        }
        System.out.println("service1 结束----->");
    }

    // 测试 有返回值异步执行
    public void service2(){
        long l = System.currentTimeMillis();
        System.out.println("service2 执行----->");
        List<Future> result = new ArrayList<>();
        try {
            for (int i = 0; i < 300; i++) {
                Future<Integer> integerFuture = asyncExecutorTest.test1(i);
                result.add(integerFuture);
            }
            for (Future future : result) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("service2执行出错");
        }
        System.out.println("service2 结束----->" + (System.currentTimeMillis() - l));
    }

    // 测试 有返回值异步执行
    public void service3(){
        long l = System.currentTimeMillis();
        List<Integer> result = new ArrayList<>();
        try {
            System.out.println("service3 执行----->");
            int total = 300;
            CountDownLatch latch = new CountDownLatch(total);
            for (int i = 0; i < total; i++) {
                final int y = i;
                localBootAsyncExecutor.execute(() -> {
                    try {
                        result.add(asyncExecutorTest.test2(y));
                    } catch (InterruptedException e) {
                        System.out.println("service3执行出错");
                    } finally {
                        latch.countDown();
                    }
                });
            }
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("service3执行出错");
        }
        System.out.println("service3 结束----->" + (System.currentTimeMillis() - l));
    }
}
