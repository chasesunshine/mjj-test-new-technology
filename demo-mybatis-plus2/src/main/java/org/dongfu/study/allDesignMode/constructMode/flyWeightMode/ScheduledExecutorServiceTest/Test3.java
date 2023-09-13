package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.ScheduledExecutorServiceTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * scheduleWithFixedDelay 正常使用
 *
 * scheduleWithFixedDelay以上一次任务的结束时间 + 延迟时间 = 下一次任务的开始时间。
 */
public class Test3 {
    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) throws Exception {
        scheduler = Executors.newScheduledThreadPool(5);

        System.out.println("main thread time : " + formatDateToString(new Date()));

        // 循环任务，按照上一次任务的发起时间计算下一次任务的开始时间
        scheduler.scheduleWithFixedDelay(
                (
                        (
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        String startString = " 开始 threadId = " + Thread.currentThread().getId() + ",,,threadName = " + Thread.currentThread().getName() + ",,,时间" +  formatDateToString(new Date());
                                        System.out.println(startString);

                                        try {
                                            Thread.sleep(3000);
                                            String endString =" 结束 threadId = " + Thread.currentThread().getId() + ",,,threadName = " + Thread.currentThread().getName() + ",,,时间" + formatDateToString(new Date());
                                            System.out.println(endString);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                        )
                ),
                2, 1, TimeUnit.SECONDS);
    }

    public static String formatDateToString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(time);
    }

}
