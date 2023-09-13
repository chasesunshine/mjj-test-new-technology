package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.ScheduledExecutorServiceTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * scheduleAtFixedRate 正常使用 延迟时间1S，执行任务时间 1S，间隔时间3S，
 */

/**
 * 可以看到任务开始时间的间隔 为我们设置的 period 间隔时间3s，
 * 计算方式就是 initialDelay 初始延迟时间（第一次任务执行的间隔时间） +  n * period（间隔时间） 0s  3s  6s 来计算
 */
public class Test2 {

    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) throws Exception {
        scheduler = Executors.newScheduledThreadPool(5);

        System.out.println("main thread time : " + formatDateToString(new Date()));

        // 循环任务，按照上一次任务的发起时间计算下一次任务的开始时间
        scheduler.scheduleAtFixedRate(
                (
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        String startString = " 开始 threadId = " + Thread.currentThread().getId() + ",,,threadName = " + Thread.currentThread().getName() + ",,,时间" +  formatDateToString(new Date());
                                        System.out.println(startString);

                                        try {
                                            //延时一秒
                                            Thread.sleep(1000);
                                            String endString = " 结束 threadId = " + Thread.currentThread().getId() + ",,,threadName = " + Thread.currentThread().getName() + ",,,时间" + formatDateToString(new Date());
                                            System.out.println(endString);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                        )
                ),
                5, 3, TimeUnit.SECONDS);
    }

    public static String formatDateToString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(time);
    }
}
