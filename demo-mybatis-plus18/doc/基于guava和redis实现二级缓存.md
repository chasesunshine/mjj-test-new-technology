# 基于guava和redis实现二级缓存 (百度智能回答)
    以下是一个简单的基于Guava和Redis实现二级缓存的示例代码。
    首先，确保你已经引入了Guava和Jedis的依赖。

    <!-- Guava -->
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>30.1-jre</version> <!-- 使用最新的稳定版本 -->
    </dependency>
    
    <!-- Redis -->
    <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>3.6.0</version> <!-- 使用最新的稳定版本 -->
    </dependency>

    接下来，实现二级缓存：
    import com.google.common.cache.CacheBuilder;
    import com.google.common.cache.CacheLoader;
    import com.google.common.cache.LoadingCache;
    import redis.clients.jedis.Jedis;
    
    import java.util.concurrent.TimeUnit;
    
    public class GuavaRedisCache {

        private final LoadingCache<String, String> cache;
        private final Jedis jedis;
     
        public GuavaRedisCache(int expireAfterWriteSeconds, Jedis jedis) {
            this.jedis = jedis;
            this.cache = CacheBuilder.newBuilder()
                    .expireAfterWrite(expireAfterWriteSeconds, TimeUnit.SECONDS)
                    .build(new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            // 当缓存未命中时，从Redis加载数据
                            return jedis.get(key);
                        }
                    });
        }
     
        public String get(String key) {
            try {
                return cache.get(key);
            } catch (Exception e) {
                // 处理异常
                return null;
            }
        }
     
        public void put(String key, String value) {
            // 更新Redis和Guava缓存
            jedis.set(key, value);
            cache.put(key, value);
        }
     
        public void invalidate(String key) {
            // 从Guava缓存中删除条目
            cache.invalidate(key);
            // 同时删除Redis中的数据
            jedis.del(key);
        }
     
        public void close() {
            // 关闭资源
            cache.cleanUp();
            jedis.close();
        }
    }


    使用示例：
        public class CacheUsage {
        public static void main(String[] args) {
            Jedis jedis = new Jedis("localhost");
            GuavaRedisCache cache = new GuavaRedisCache(3600, jedis);
     
            // 获取数据
            String value = cache.get("myKey");
            if (value == null) {
                // 缓存未命中，需要从数据库或其他数据源获取数据
                value = "myValue";
                cache.put("myKey", value);
            }
     
            // 更新数据
            cache.put("myKey", "newValue");
     
            // 删除缓存数据
            cache.invalidate("myKey");
     
            // 关闭缓存
            cache.close();
            jedis.close();
        }
    }