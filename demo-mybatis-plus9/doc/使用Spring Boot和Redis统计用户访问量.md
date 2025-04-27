# 使用Spring Boot和Redis统计用户访问量

在Spring Boot应用中，使用Redis统计用户访问量是一种高效且可扩展的方案。下面我将介绍几种实现方式：

## 1. 基本实现方案

### 1.1 添加依赖

首先在`pom.xml`中添加Redis相关依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

### 1.2 配置Redis连接

在`application.properties`或`application.yml`中配置Redis：

```properties
spring.redis.host=localhost
spring.redis.port=6379
```

### 1.3 创建访问统计服务

```java
@Service
public class VisitStatisticsService {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    private static final String TOTAL_VISITS_KEY = "stat:visits:total";
    private static final String DAILY_VISITS_KEY_PREFIX = "stat:visits:daily:";
    
    /**
     * 记录用户访问
     * @param userId 用户ID
     */
    public void recordVisit(String userId) {
        // 总访问量+1
        redisTemplate.opsForValue().increment(TOTAL_VISITS_KEY);
        
        // 每日访问量+1
        String todayKey = DAILY_VISITS_KEY_PREFIX + LocalDate.now().toString();
        redisTemplate.opsForValue().increment(todayKey);
        
        // 记录用户访问(可选)
        if (userId != null) {
            String userVisitsKey = "stat:user:visits:" + userId;
            redisTemplate.opsForZSet().incrementScore(userVisitsKey, LocalDate.now().toString(), 1);
        }
    }
    
    /**
     * 获取总访问量
     */
    public long getTotalVisits() {
        String value = redisTemplate.opsForValue().get(TOTAL_VISITS_KEY);
        return value == null ? 0 : Long.parseLong(value);
    }
    
    /**
     * 获取某天的访问量
     */
    public long getDailyVisits(LocalDate date) {
        String key = DAILY_VISITS_KEY_PREFIX + date.toString();
        String value = redisTemplate.opsForValue().get(key);
        return value == null ? 0 : Long.parseLong(value);
    }
}
```

### 1.4 在控制器中使用

```java
@RestController
public class VisitController {
    
    @Autowired
    private VisitStatisticsService visitStatisticsService;
    
    @GetMapping("/visit")
    public String visit(@RequestParam(required = false) String userId) {
        visitStatisticsService.recordVisit(userId);
        return "Visit recorded";
    }
    
    @GetMapping("/stats/total")
    public long getTotalVisits() {
        return visitStatisticsService.getTotalVisits();
    }
    
    @GetMapping("/stats/daily")
    public long getDailyVisits(@RequestParam String date) {
        return visitStatisticsService.getDailyVisits(LocalDate.parse(date));
    }
}
```

## 2. 高级实现方案

### 2.1 使用HyperLogLog统计UV(独立访客)

对于大规模UV统计，可以使用Redis的HyperLogLog数据结构：

```java
public void recordUniqueVisit(String userId) {
    String todayUVKey = "stat:uv:daily:" + LocalDate.now().toString();
    redisTemplate.opsForHyperLogLog().add(todayUVKey, userId);
}

public long getDailyUniqueVisits(LocalDate date) {
    String key = "stat:uv:daily:" + date.toString();
    return redisTemplate.opsForHyperLogLog().size(key);
}
```

### 2.2 使用Bitmap统计活跃用户

```java
public void recordActiveUser(String userId) {
    String todayActiveKey = "stat:active:daily:" + LocalDate.now().toString();
    // 假设userId可以转换为数字ID
    long userIdLong = Long.parseLong(userId);
    redisTemplate.opsForValue().setBit(todayActiveKey, userIdLong, true);
}

public long countDailyActiveUsers(LocalDate date) {
    String key = "stat:active:daily:" + date.toString();
    byte[] bitmap = redisTemplate.execute((RedisCallback<byte[]>) connection -> 
        connection.get(key.getBytes()));
    
    if (bitmap == null) return 0;
    
    long count = 0;
    for (byte b : bitmap) {
        count += Integer.bitCount(b & 0xFF);
    }
    return count;
}
```

## 3. 使用Redis的ZSET实现排行榜

```java
public void recordVisitWithScore(String userId, int score) {
    String rankingKey = "stat:user:ranking";
    redisTemplate.opsForZSet().incrementScore(rankingKey, userId, score);
}

public Set<ZSetOperations.TypedTuple<String>> getTopUsers(int limit) {
    return redisTemplate.opsForZSet().reverseRangeWithScores("stat:user:ranking", 0, limit - 1);
}
```

## 4. 使用AOP实现全局访问统计

可以创建一个切面来自动统计所有请求：

```java
@Aspect
@Component
public class VisitStatisticsAspect {
    
    @Autowired
    private VisitStatisticsService visitStatisticsService;
    
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object recordVisit(ProceedingJoinPoint joinPoint) throws Throwable {
        // 从请求中获取用户ID，实际项目中可能从Session或Token中获取
        HttpServletRequest request = ((ServletRequestAttributes) 
            RequestContextHolder.currentRequestAttributes()).getRequest();
        String userId = request.getHeader("X-User-ID");
        
        visitStatisticsService.recordVisit(userId);
        
        return joinPoint.proceed();
    }
}
```

## 5. 性能优化建议

1. **批量操作**：对于高频访问，考虑使用Redis的管道(pipeline)批量提交命令
2. **定期持久化**：定期将Redis数据持久化到数据库
3. **内存优化**：根据数据类型选择合适的数据结构
4. **过期设置**：为临时统计数据设置合理的过期时间

以上方案可以根据实际业务需求进行组合和调整，Redis提供了丰富的数据结构和命令来支持各种统计场景。