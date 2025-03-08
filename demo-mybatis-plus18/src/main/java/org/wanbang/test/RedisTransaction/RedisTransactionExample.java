package org.wanbang.test.RedisTransaction;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTransactionExample {
    public static void main(String[] args) {
        // 创建 Jedis 实例
        Jedis jedis = new Jedis("localhost", 6379);

        // 开启事务
        Transaction transaction = jedis.multi();

        try {
            // 添加命令到事务
            transaction.set("key1", "value1");
            transaction.set("key2", "value2");

//            if(true){
//                throw new RuntimeException();
//            }
            // 提交事务
            transaction.exec();
            System.out.println("事务执行成功！");
        } catch (Exception e) {
            // 取消事务
            transaction.discard();
            System.out.println("事务执行失败，已回滚！");
        } finally {
            // 关闭 Jedis 连接
            jedis.close();
        }
    }
}
