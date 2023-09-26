package org.wanbang.study.delayQueue.redisSortedSet;

public class Redis {
    /**
     * 消费消息
     */
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
