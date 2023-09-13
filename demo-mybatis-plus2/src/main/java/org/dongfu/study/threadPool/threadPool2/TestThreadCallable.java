package org.dongfu.study.threadPool.threadPool2;

import java.util.concurrent.*;

public class TestThreadCallable {
    public static void main(String[] args) {
        //使用main方法模拟Callable的call()方法的调用
        CallableTest callableTest = new CallableTest("我是阿T");
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("开始执行call()方法!");
        Future<String> future = executorService.submit(callableTest);
        try {
            System.out.println("这里是为了测试一下程序的执行。");
            System.out.println("调用call()方法返回的结果："+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
