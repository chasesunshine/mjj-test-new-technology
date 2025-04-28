# Spring Boot 监听 Redis 过期 Key 方案（继承 KeyspaceEventMessageListener）

在 Spring Boot 中监听 Redis 的 key 过期事件，可以通过继承 `KeyspaceEventMessageListener` 来实现。以下是完整的实现方案：

## 1. 配置 Redis 启用键空间通知

首先需要确保 Redis 服务器配置了键空间通知功能： (马佳健个人没用这个)

```properties
# application.properties
spring.redis.database=0
spring.redis.host=localhost
spring.redis.port=6379

# 配置监听所有键空间事件（生产环境应根据需要调整）
spring.redis.listen-pattern=__keyevent@*__:expired
```

或者在 Redis 配置文件中设置（redis.conf）： (马佳健个人用的这个)
```
notify-keyspace-events Ex
```

## 2. 实现自定义监听器

```java
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener extends KeyspaceEventMessageListener {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisKeyExpirationListener(
            RedisMessageListenerContainer listenerContainer,
            RedisTemplate<String, Object> redisTemplate) {
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
}
```

## 3. 配置 RedisMessageListenerContainer

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }
}
```

## 4. 注意事项

1. **性能考虑**：大量 key 过期可能会产生大量事件，影响 Redis 性能
2. **可靠性**：Redis 的键空间通知不保证可靠性，可能会丢失事件
3. **替代方案**：对于重要业务，可以考虑使用 Redis 的 Stream 或者 RDB 持久化结合定时任务检查
4. **数据获取**：key 过期时，对应的 value 已经不可访问，如果需要 value，应在过期前保存

## 5. 高级用法 - 使用自定义序列化

如果 Redis 使用了自定义序列化，需要调整监听器：

```java
@Override
public void onMessage(Message message, byte[] pattern) {
    // 使用与RedisTemplate相同的序列化方式
    String expiredKey = (String) redisTemplate.getKeySerializer().deserialize(message.getBody());
    System.out.println("Key expired: " + expiredKey);
}
```

## 6. 测试用例

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisExpireTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testKeyExpiration() throws InterruptedException {
        String key = "test:expire:key";
        redisTemplate.opsForValue().set(key, "value", 5, TimeUnit.SECONDS);
        System.out.println("Key set with expiration");

        // 等待过期事件触发
        Thread.sleep(10000);
    }
}
```

通过以上方案，你可以成功监听 Redis 中的 key 过期事件并执行相应的业务逻辑。