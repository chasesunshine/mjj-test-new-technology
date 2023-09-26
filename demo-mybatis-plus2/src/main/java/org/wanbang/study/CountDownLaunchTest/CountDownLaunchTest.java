package org.wanbang.study.CountDownLaunchTest;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuhuifang
 * @date 2022/5/26 11:31
 */
public class CountDownLaunchTest {

    /**
     *  CountDownLatch(int count)：count为计数器的初始值（一般需要多少个线程执行，count就设为几）。
     *  countDown(): 每调用一次计数器值-1，直到count被减为0，代表所有线程全部执行完毕。
     *  getCount()：获取当前计数器的值。
     *  await(): 等待计数器变为0，即等待所有异步线程执行完毕。
     *  boolean await(long timeout, TimeUnit unit)： 此方法与await()区别：
     *      ①此方法至多会等待指定的时间，超时后会自动唤醒，若 timeout 小于等于零，则不会等待
     *      ②boolean 类型返回值：若计数器变为零了，则返回 true；若指定的等待时间过去了，则返回 false
     *
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList();
        for(int i = 1; i<=100; i++){
            list.add(i);
        }
//        Long start = System.currentTimeMillis();
//        for(int i = 0; i<list.size(); i++){
//            Thread.sleep(100);
//        }
//        System.out.println("=====同步执行：耗时"+(System.currentTimeMillis()-start)+"毫秒======");



        Long start1 = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(10);
        for(int i = 0; i<latch.getCount(); i++){
            new Thread(new Test(latch, i, list)).start();
        }
        latch.await();
        System.out.println("=====异步执行：耗时"+(System.currentTimeMillis()-start1)+"毫秒======");
    }

    static class Test implements Runnable{
        private CountDownLatch latch;
        private int i;
        private List list;
        Test(CountDownLatch latch, int i, List list){
            this.latch = latch;
            this.i = i;
            this.list = list;
        }

        @SneakyThrows
        @Override
        public void run() {
            for(int a = i*10; a<(i+1)*10; a++){
                // 执行任务逻辑
                Thread.sleep(100);
            }
            latch.countDown();
        }
    }
}

