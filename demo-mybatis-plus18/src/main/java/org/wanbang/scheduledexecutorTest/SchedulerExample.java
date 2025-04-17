package org.wanbang.scheduledexecutorTest;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class SchedulerExample {

    @EventListener(ApplicationStartedEvent.class)
    public void testScheduler(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running at " + System.currentTimeMillis());
            }
        };

        // 安排一个任务，在1秒后首次执行，然后每隔2秒执行一次
//        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // 如果你想要在一定时间后关闭调度器，可以这样做：
        // scheduler.schedule(() -> scheduler.shutdown(), 60, TimeUnit.SECONDS);
    }

}
