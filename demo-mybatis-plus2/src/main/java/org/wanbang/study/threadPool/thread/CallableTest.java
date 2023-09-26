package org.wanbang.study.threadPool.thread;

import java.util.concurrent.*;

// 创建线程方式三：实现Callable接口
// 使用Callable的好处：1.可以定义返回值 2.抛出异常
public class CallableTest {
    // 与使用Runnable相比，Callable功能更强大些相比run()方法，可以有返回值
    // - 与使用Runnable相比，可调用功能更强大些相比run()方法，可以有返回值
    // - 方法可以抛出异常
    // - 支持泛型的返回值
    // - 需要借助FutureTask类，比如获取返回结果
    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        // 为什么这么写 因为要 callable重写方法有抛出异常
        FutureTask f = new FutureTask(callableThread);

        new Thread(f).start();

        try {
            Object sum = f.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableThread implements Callable {
    @Override
    public Object call () {
        int sum =0;
        for(int i=0;i<100;i++){
            if(i%2==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=i;
            }
        }
        return sum;

    }
}