package org.wanbang.study.delayQueue.redisExpiredTime;

import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener {

}/*extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        System.out.println("监听到key：" + expiredKey + "已过期");
    }
}*/
