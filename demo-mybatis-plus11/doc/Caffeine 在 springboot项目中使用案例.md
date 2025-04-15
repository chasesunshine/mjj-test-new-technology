# Caffeine 在 springboot项目中使用案例

在 Spring Boot 项目中使用 Caffeine 缓存可以显著提升应用性能，尤其是在处理频繁的读取操作时。以下是一个完整的示例，展示了如何在 Spring Boot 项目中集成和使用 Caffeine 缓存。

1. 添加依赖
    首先，在 pom.xml 文件中添加 Spring Cache 和 Caffeine 的依赖：

    Xml
    深色版本
    <dependencies>
        <!-- Spring Boot Starter Cache -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>

        <!-- Caffeine 缓存提供商 -->
        <dependency>
            <groupId>com.github.ben-manes.caffeine</groupId>
            <artifactId>caffeine</artifactId>
        </dependency>

        <!-- Spring Boot Starter Web (可选，如果你的应用是一个Web应用) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

2. 启用缓存
    在主类或配置类上添加 @EnableCaching 注解，启用 Spring Cache 支持：

    Java
    深色版本
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.cache.annotation.EnableCaching;

    @SpringBootApplication
    @EnableCaching
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }

3. 配置 Caffeine 缓存
    创建一个配置类来配置 Caffeine 缓存：

    Java
    深色版本
    import com.github.benmanes.caffeine.cache.Caffeine;
    import org.springframework.cache.CacheManager;
    import org.springframework.cache.annotation.EnableCaching;
    import org.springframework.cache.caffeine.CaffeineCacheManager;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class CacheConfig {

        @Bean
        public CacheManager cacheManager() {
            CaffeineCacheManager cacheManager = new CaffeineCacheManager();
            cacheManager.setCaffeine(caffeineCacheBuilder());
            return cacheManager;
        }

        @Bean
        public Caffeine<Object, Object> caffeineCacheBuilder() {
            return Caffeine.newBuilder()
                    .maximumSize(100) // 最大缓存条目数
                    .expireAfterWrite(1, TimeUnit.MINUTES) // 写入后1分钟过期
                    .recordStats(); // 记录缓存统计信息
        }
    }

4. 使用缓存注解
    在服务类中使用 @Cacheable、@CachePut 和 @CacheEvict 注解来管理缓存。

    示例服务类
    Java
    深色版本
    import org.springframework.cache.annotation.Cacheable;
    import org.springframework.stereotype.Service;

    @Service
    public class UserService {

        @Cacheable(value = "users", key = "#userId", unless = "#result == null")
        public User getUserById(Long userId) {
            // 模拟从数据库中查询数据
            System.out.println("Fetching user from database...");
            return new User(userId, "User" + userId);
        }

        @CachePut(value = "users", key = "#user.id")
        public User updateUser(User user) {
            // 模拟更新数据库中的用户信息
            System.out.println("Updating user in database...");
            return user;
        }

        @CacheEvict(value = "users", key = "#userId")
        public void deleteUser(Long userId) {
            // 模拟从数据库中删除用户
            System.out.println("Deleting user from database...");
        }
    }

5. 创建实体类
    创建一个简单的 User 实体类：

    Java
    深色版本
    public class User {
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

6. 创建控制器
    创建一个控制器来测试缓存功能：

    Java
    深色版本
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/users")
    public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
        }

        @PostMapping
        public User createUser(@RequestBody User user) {
            return userService.updateUser(user);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
        }
    }
    
7. 测试缓存功能
    启动应用后，可以通过以下方式测试缓存功能：

    获取用户信息：
    发送 GET 请求到 /users/1，第一次请求会从数据库中获取数据并缓存。
    再次发送相同的请求，数据将直接从缓存中获取，不会打印 "Fetching user from database..."。
    更新用户信息：
    发送 POST 请求到 /users，更新用户信息并更新缓存。
    删除用户信息：
    发送 DELETE 请求到 /users/1，删除用户信息并从缓存中移除。
    通过以上步骤，你可以在 Spring Boot 项目中成功集成和使用 Caffeine 缓存，提高应用的性能和响应速度。

# springboot中获取所有caffeine数据
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.cache.CacheManager;
    import org.springframework.cache.caffeine.CaffeineCache;
    import org.springframework.stereotype.Service;
    
    import java.util.HashMap;
    import java.util.Map;
    
    @Service
    public class CaffeineService {
    
        @Autowired
        private CacheManager cacheManager;
     
        public Map<String, Object> getAllCaffeineData() {
            Map<String, Object> allCachesData = new HashMap<>();
            for (String cacheName : cacheManager.getCacheNames()) {
                CaffeineCache cache = (CaffeineCache) cacheManager.getCache(cacheName);
                allCachesData.put(cacheName, cache.getNativeCache().asMap());
            }
            return allCachesData;
        }
    }
    在这个例子中，CaffeineService类的getAllCaffeineData方法遍历了所有缓存，并将每个缓存的名称和内容存储在一个Map对象中。这个方法可以被注解为@Scheduled，定期执行以获取缓存数据的快照。