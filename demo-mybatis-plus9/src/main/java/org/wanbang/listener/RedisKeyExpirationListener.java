package org.wanbang.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener extends KeyspaceEventMessageListener {

    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer, RedisTemplate<Object, Object> redisTemplate) {
        super(listenerContainer);
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doRegister(RedisMessageListenerContainer listenerContainer) {
        // 监听所有数据库的过期事件
        listenerContainer.addMessageListener(this, new PatternTopic("__keyevent@*__:expired"));
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取过期的key
        String expiredKey = message.toString();

        // 这里处理你的业务逻辑
        System.out.println("Key expired: " + expiredKey);

        // 如果需要获取key对应的value，可以在过期前将其存入另一个临时key中
        // 或者使用其他策略处理
    }

    @Override
    protected void doHandleMessage(Message message) {

    }
}
