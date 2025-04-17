# Java供应链项目中使用分布式锁和库存分段解决超买超卖问题

下面我将提供一个完整的案例代码，展示如何在Java供应链项目中使用分布式锁和库存分段技术来解决超卖问题。

## 1. 问题背景

在供应链系统中，库存管理是一个核心功能。当多个用户同时抢购同一商品时，传统的数据库更新方式可能会导致超卖问题（库存减为负数）。分布式锁和库存分段是解决这个问题的有效方案。

## 2. 解决方案概述

- **分布式锁**：防止多个节点同时修改同一库存
- **库存分段**：将库存分成多个段，减少锁竞争，提高并发性能

## 3. 完整实现代码

### 3.1 依赖配置 (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Redis for distributed lock -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>

    <!-- Redisson for distributed lock -->
    <dependency>
        <groupId>org.redisson</groupId>
        <artifactId>redisson-spring-boot-starter</artifactId>
        <version>3.16.8</version>
    </dependency>

    <!-- MyBatis Plus -->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.5.1</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

### 3.2 库存分段实体类

```java
@Data
@TableName("inventory_segment")
public class InventorySegment {
    @TableId(type = IdType.AUTO)
    private Long id;

    // 商品ID
    private Long productId;

    // 分段编号
    private Integer segmentNo;

    // 分段库存数量
    private Integer stock;

    // 版本号，用于乐观锁
    private Integer version;
}
```

### 3.3 分布式锁服务

```java
@Service
public class DistributedLockService {
    private final RedissonClient redissonClient;

    public DistributedLockService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 获取分布式锁
     * @param lockKey 锁的key
     * @param waitTime 等待时间(秒)
     * @param leaseTime 持有时间(秒)
     * @return 是否获取成功
     */
    public boolean tryLock(String lockKey, long waitTime, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * 释放锁
     * @param lockKey 锁的key
     */
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        if (lock.isLocked() && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}
```

### 3.4 库存服务实现

```java
@Service
public class InventoryServiceImpl implements InventoryService {
    private static final int SEGMENT_COUNT = 10; // 库存分段数量

    @Autowired
    private InventorySegmentMapper segmentMapper;

    @Autowired
    private DistributedLockService lockService;

    @Override
    @Transactional
    public boolean reduceInventory(Long productId, int quantity) {
        // 1. 获取商品所有库存分段
        List<InventorySegment> segments = segmentMapper.selectList(
            new LambdaQueryWrapper<InventorySegment>()
                .eq(InventorySegment::getProductId, productId)
                .orderByAsc(InventorySegment::getSegmentNo)
        );

        if (segments.isEmpty()) {
            throw new RuntimeException("商品库存不存在");
        }

        int remaining = quantity;

        // 2. 尝试从各个分段扣减库存
        for (InventorySegment segment : segments) {
            if (remaining <= 0) break;

            String lockKey = "inventory:lock:" + productId + ":" + segment.getSegmentNo();

            try {
                // 获取分布式锁
                if (!lockService.tryLock(lockKey, 3, 10)) {
                    continue; // 获取锁失败，尝试下一个分段
                }

                // 检查分段库存是否足够
                if (segment.getStock() > 0) {
                    int deduct = Math.min(remaining, segment.getStock());

                    // 乐观锁更新库存
                    int updated = segmentMapper.reduceStock(
                        segment.getId(),
                        deduct,
                        segment.getVersion()
                    );

                    if (updated > 0) {
                        remaining -= deduct;
                        segment.setStock(segment.getStock() - deduct);
                        segment.setVersion(segment.getVersion() + 1);
                    }
                }
            } finally {
                // 释放锁
                lockService.unlock(lockKey);
            }
        }

        if (remaining > 0) {
            throw new RuntimeException("库存不足");
        }

        return true;
    }

    @Override
    public void initInventory(Long productId, int totalStock) {
        // 删除旧的分段
        segmentMapper.delete(
            new LambdaQueryWrapper<InventorySegment>()
                .eq(InventorySegment::getProductId, productId)
        );

        // 计算每个分段的库存
        int baseStock = totalStock / SEGMENT_COUNT;
        int remainder = totalStock % SEGMENT_COUNT;

        // 创建新的分段
        for (int i = 0; i < SEGMENT_COUNT; i++) {
            InventorySegment segment = new InventorySegment();
            segment.setProductId(productId);
            segment.setSegmentNo(i);
            segment.setStock(i < remainder ? baseStock + 1 : baseStock);
            segment.setVersion(0);
            segmentMapper.insert(segment);
        }
    }
}
```

### 3.5 Mapper接口

```java
@Mapper
public interface InventorySegmentMapper extends BaseMapper<InventorySegment> {

    @Update("UPDATE inventory_segment SET stock = stock - #{deduct}, version = version + 1 " +
            "WHERE id = #{id} AND version = #{version} AND stock >= #{deduct}")
    int reduceStock(@Param("id") Long id,
                   @Param("deduct") int deduct,
                   @Param("version") int version);
}
```

### 3.6 控制器

```java
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/reduce")
    public ResponseEntity<String> reduceInventory(
            @RequestParam Long productId,
            @RequestParam int quantity) {
        try {
            boolean success = inventoryService.reduceInventory(productId, quantity);
            if (success) {
                return ResponseEntity.ok("库存扣减成功");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("库存不足");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("库存扣减失败: " + e.getMessage());
        }
    }

    @PostMapping("/init")
    public ResponseEntity<String> initInventory(
            @RequestParam Long productId,
            @RequestParam int totalStock) {
        inventoryService.initInventory(productId, totalStock);
        return ResponseEntity.ok("库存初始化成功");
    }
}
```

### 3.7 Redisson配置

```java
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
              .setAddress("redis://" + redisHost + ":" + redisPort);
        return Redisson.create(config);
    }
}
```

## 4. 方案优势

1. **分布式锁**：使用Redisson实现的分布式锁，确保同一时间只有一个服务实例可以修改特定库存分段
2. **库存分段**：将库存分成多个段，减少锁竞争，提高并发性能
3. **乐观锁**：结合版本号实现乐观锁，防止并发修改导致的数据不一致
4. **可扩展性**：通过增加分段数量可以进一步提高并发性能

## 5. 测试用例

```java
@SpringBootTest
public class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventorySegmentMapper segmentMapper;

    private Long testProductId = 1L;

    @BeforeEach
    public void setup() {
        // 初始化测试商品库存
        inventoryService.initInventory(testProductId, 1000);
    }

    @Test
    public void testConcurrentInventoryReduction() throws InterruptedException {
        int threadCount = 100;
        int reducePerThread = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    inventoryService.reduceInventory(testProductId, reducePerThread);
                } catch (Exception e) {
                    System.out.println("库存扣减失败: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();

        // 验证总库存是否正确
        List<InventorySegment> segments = segmentMapper.selectList(
            new LambdaQueryWrapper<InventorySegment>()
                .eq(InventorySegment::getProductId, testProductId)
        );

        int remainingStock = segments.stream().mapToInt(InventorySegment::getStock).sum();
        assertEquals(0, remainingStock, "最终库存应为0");
    }
}
```

## 6. 总结

这个解决方案通过以下方式有效解决了超卖问题：

1. **分布式锁**：确保同一时间只有一个服务实例可以修改特定库存分段
2. **库存分段**：将库存分成多个段，减少锁竞争，提高并发性能
3. **乐观锁**：通过版本号机制防止并发修改导致的数据不一致

在实际生产环境中，可以根据业务需求调整分段数量，并在库存不足时实现更复杂的回退逻辑。此外，还可以考虑引入缓存来进一步提高性能。

这个方案适用于高并发的供应链系统、电商秒杀系统等需要精确库存控制的场景。