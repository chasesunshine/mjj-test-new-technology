# guava 作为本地缓存demo
    Guava 提供了本地缓存的实现，你可以使用 CacheBuilder 来创建自定义的缓存。以下是一个简单的本地缓存的示例代码：
    import com.google.common.cache.CacheBuilder;
    import com.google.common.cache.CacheLoader;
    import com.google.common.cache.LoadingCache;
    import java.util.concurrent.TimeUnit;
    
    public class GuavaCacheDemo {
    
        // 创建一个缓存器，缓存最多100个元素，过期时间5分钟
        private static final LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    // 定义如何加载和计算缓存值
                    @Override
                    public String load(String key) throws Exception {
                        return "value_" + key;
                    }
                });
     
        public static void main(String[] args) throws Exception {
            // 尝试从缓存获取数据，如果没有则通过CacheLoader加载
            String key = "myKey";
            String value = cache.get(key);
            System.out.println("Value for key '" + key + "' is: " + value);
     
            // 也可以通过这种方式获取数据，如果key不存在，则返回null
            String value2 = cache.getIfPresent(key);
            if (value2 != null) {
                System.out.println("Value for key '" + key + "' is: " + value2);
            } else {
                System.out.println("Key '" + key + "' not found in cache.");
            }
        }
    }

    在这个例子中，我们创建了一个缓存器，最大容量为100个元素，并且每个元素在写入后5分钟内会过期。如果尝试获取一个不在缓存中的元素，CacheLoader 的 load 方法会被调用来计算新的值。
