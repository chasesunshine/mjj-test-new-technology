# Spring Boot 多线程导入百万级Excel数据到数据库

处理百万级Excel数据导入是一个典型的I/O密集型和CPU密集型混合任务，合理使用多线程可以显著提高导入速度。下面是一个完整的解决方案：

## 核心思路

1. **分片处理**：将大Excel文件拆分为多个小批次处理
2. **多线程并发**：使用线程池并行处理各个批次
3. **批量插入**：使用JDBC批量插入减少数据库I/O
4. **内存管理**：合理控制内存使用，避免OOM

## 实现代码

### 1. Controller层

```java
@RestController
@RequestMapping("/import")
public class ExcelImportController {
    
    @Autowired
    private ExcelImportService excelImportService;
    
    @PostMapping("/excel")
    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请上传文件");
        }
        
        try {
            long start = System.currentTimeMillis();
            int total = excelImportService.importLargeExcel(file);
            long time = (System.currentTimeMillis() - start) / 1000;
            
            return ResponseEntity.ok(String.format("导入成功，共%d条数据，耗时%d秒", total, time));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("导入失败: " + e.getMessage());
        }
    }
}
```

### 2. Service层实现

```java
@Service
public class ExcelImportServiceImpl implements ExcelImportService {
    
    // 线程池配置
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2;
    private static final int QUEUE_CAPACITY = 1000;
    private static final int BATCH_SIZE = 5000; // 每个批次处理5000条
    
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy());
    
    @Autowired
    private DataRepository dataRepository;
    
    @Override
    public int importLargeExcel(MultipartFile file) throws Exception {
        // 使用EasyExcel读取，更节省内存
        ExcelReader excelReader = EasyExcel.read(file.getInputStream())
                .head(DataModel.class)
                .registerReadListener(new ExcelDataListener())
                .build();
        
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
        
        return ((ExcelDataListener)listener).getTotal();
    }
    
    // Excel数据监听器，实现分片和多线程处理
    private class ExcelDataListener extends AnalysisEventListener<DataModel> {
        private AtomicInteger total = new AtomicInteger(0);
        private List<DataModel> batchList = new ArrayList<>(BATCH_SIZE);
        
        @Override
        public void invoke(DataModel data, AnalysisContext context) {
            batchList.add(data);
            if (batchList.size() >= BATCH_SIZE) {
                // 提交批次任务到线程池
                submitBatch(new ArrayList<>(batchList));
                batchList.clear();
            }
        }
        
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            // 处理最后一批数据
            if (!batchList.isEmpty()) {
                submitBatch(batchList);
            }
        }
        
        private void submitBatch(List<DataModel> batch) {
            List<DataModel> copy = new ArrayList<>(batch);
            executor.execute(() -> {
                // 这里可以使用批量插入
                dataRepository.batchInsert(copy);
                total.addAndGet(copy.size());
            });
        }
        
        public int getTotal() {
            // 等待所有任务完成
            while (executor.getActiveCount() > 0 || !executor.getQueue().isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return total.get();
        }
    }
}
```

### 3. Repository层（使用JPA示例）

```java
@Repository
public class DataRepositoryImpl implements DataRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public void batchInsert(List<DataModel> list) {
        final int batchSize = 500; // 每批插入500条
        
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(list.get(i));
        }
        entityManager.flush();
        entityManager.clear();
    }
}
```

## 优化建议

1. **选择合适的Excel解析库**：
   - 使用EasyExcel或Apache POI的SAX模式（XSSF SAX API）来避免内存溢出
   - 避免使用DOM模式加载整个Excel文件

2. **线程池调优**：
   - 根据服务器CPU核心数设置合适的线程数
   - 考虑使用有界队列防止内存溢出
   - 设置合理的拒绝策略

3. **数据库优化**：
   - 在导入前暂时关闭索引，导入后重建
   - 使用批量插入代替单条插入
   - 考虑使用LOAD DATA INFILE（MySQL）等数据库特有批量导入功能

4. **内存控制**：
   - 限制每批次处理的数据量
   - 定期清理缓存和释放资源

5. **监控与反馈**：
   - 添加进度监控功能
   - 实现断点续传功能

## 扩展功能

1. **进度查询接口**：
```java
@GetMapping("/progress")
public ResponseEntity<ImportProgress> getImportProgress() {
    return ResponseEntity.ok(excelImportService.getProgress());
}
```

2. **异常处理**：
   - 记录处理失败的行和数据
   - 提供错误报告下载

3. **性能监控**：
   - 记录每个批次的处理时间
   - 动态调整批次大小

通过以上方法，可以有效地将百万级Excel数据快速导入数据库，同时保证系统的稳定性和可靠性。

# 总结
   提升Excel导入速度的方法：
   1.使用更快的 Excel 读取框架(推荐使用阿里 EasyExcel)
   2.对于需要与数据库交互的校验、按照业务逻辑适当的使用缓存。用空间换时间
   3.使用 values(),(),() 拼接长 SQL 一次插入多行数据
   4.使用多线程插入数据，利用掉网络IO等待时间(推荐使用并行流，简单易用)
   5.避免在循环中打印无用的日志
   
