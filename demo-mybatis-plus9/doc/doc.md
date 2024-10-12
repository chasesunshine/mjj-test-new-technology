# springboot项目中结合redis lru脚本并测试
        在Spring Boot项目中结合Redis实现LRU缓存，并进行测试，可以按照以下步骤操作。我们将使用Spring Data Redis提供的功能来与Redis交互，并实现一个LRU缓存管理器。

        1. 添加依赖
           首先，在pom.xml中添加Spring Data Redis的依赖：

        Xml
        深色版本
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        2. 配置Redis连接
           在application.properties中配置Redis连接信息：

        Properties
        深色版本
        spring.redis.host=localhost
        spring.redis.port=6379
        3. 创建LRU Cache Manager
           创建一个Service类来管理LRU缓存。我们将使用Redis的有序集合（Sorted Set）来实现LRU缓存逻辑，其中每个元素都有一个分数（score），这个分数可以用来表示最近访问的时间戳。

        Java
        深色版本
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.stereotype.Service;

        import java.util.Set;
        import java.util.concurrent.TimeUnit;

        @Service
        public class LruCacheManager {

            @Autowired
            private RedisTemplate<String, String> redisTemplate;

            private static final String CACHE_KEY = "LRU_CACHE";
            private static final int MAX_CACHE_SIZE = 100;

            public void put(String key, String value) {
                long currentTime = System.currentTimeMillis();
                redisTemplate.opsForValue().set(key, value, 1, TimeUnit.DAYS); // 设置过期时间为1天
                redisTemplate.opsForZSet().add(CACHE_KEY, key, currentTime);
                cleanup();
            }

            public String get(String key) {
                if (redisTemplate.hasKey(key)) {
                    long currentTime = System.currentTimeMillis();
                    redisTemplate.opsForZSet().incrementScore(CACHE_KEY, key, currentTime - redisTemplate.opsForZSet().score(CACHE_KEY, key));
                    return redisTemplate.opsForValue().get(key);
                }
                return null;
            }

            private void cleanup() {
                Set<String> keysToRemove = redisTemplate.opsForZSet().range(CACHE_KEY, 0, -MAX_CACHE_SIZE - 1);
                if (keysToRemove != null && !keysToRemove.isEmpty()) {
                    redisTemplate.delete(keysToRemove);
                    redisTemplate.opsForZSet().remove(CACHE_KEY, keysToRemove.toArray(new String[0]));
                }
            }
        }
        4. 编写测试用例
           创建一个测试类来验证LRU缓存的行为：

        Java
        深色版本
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        import static org.junit.jupiter.api.Assertions.*;

        @SpringBootTest
        public class LruCacheManagerTest {

            @Autowired
            private LruCacheManager lruCacheManager;

            @Test
            public void testLruCache() throws InterruptedException {
                lruCacheManager.put("key1", "value1");
                lruCacheManager.put("key2", "value2");
                lruCacheManager.put("key3", "value3");

                assertEquals("value1", lruCacheManager.get("key1"));

                // 模拟时间流逝
                Thread.sleep(1000);

                // 插入新的键值对，触发LRU清理
                for (int i = 4; i <= 105; i++) {
                    lruCacheManager.put("key" + i, "value" + i);
                }

                // 检查最旧的键是否被清理
                assertNull(lruCacheManager.get("key1"));
                assertEquals("value2", lruCacheManager.get("key2"));
                assertEquals("value3", lruCacheManager.get("key3"));
                assertEquals("value105", lruCacheManager.get("key105"));
            }
        }
        5. 运行测试
           运行上述测试用例，确保LRU缓存逻辑按预期工作。如果所有断言都通过，说明LRU缓存实现是正确的。

        总结
        通过以上步骤，我们成功地在Spring Boot项目中实现了基于Redis的LRU缓存，并进行了基本的测试。你可以根据实际需求调整缓存大小和过期时间等参数。