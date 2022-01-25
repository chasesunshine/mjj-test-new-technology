package org.wanbang.study.delayQueue.Quartz;

import org.assertj.core.groups.Tuple;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Set;

@Component
public class QuartzDemo {

    //每隔五秒
    @Scheduled(cron = "0/5 * * * * ? ")
    public void process(){
        System.out.println("我是定时任务！");
    }

//    /**
//     * 消费消息
//     */
//    public void pollOrderQueue() {
//
//        while (true) {
//            Set<Tuple> set = jedis.zrangeWithScores(DELAY_QUEUE, 0, 0);
//
//            String value = ((Tuple) set.toArray()[0]).getElement();
//            int score = (int) ((Tuple) set.toArray()[0]).getScore();
//
//            Calendar cal = Calendar.getInstance();
//            int nowSecond = (int) (cal.getTimeInMillis() / 1000);
//            if (nowSecond >= score) {
//                jedis.zrem(DELAY_QUEUE, value);
//                System.out.println(sdf.format(new Date()) + " removed key:" + value);
//            }
//
//            if (jedis.zcard(DELAY_QUEUE) <= 0) {
//                System.out.println(sdf.format(new Date()) + " zset empty ");
//                return;
//            }
//            Thread.sleep(1000);
//        }
//    }
}
