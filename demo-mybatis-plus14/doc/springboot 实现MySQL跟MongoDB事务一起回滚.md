在Spring Boot中，要实现MySQL和MongoDB的事务同时回滚，你需要使用@Transactional注解并确保两个数据源都配置在同一个事务管理器中。以下是一个简化的示例：

配置类：

@Configuration
public class DatabaseConfig {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory,
                                                         MongoTransactionManager mongoTransactionManager) {
        return new ChainedTransactionManager(factory.getTransactionManager(), mongoTransactionManager);
    }
}
服务层：

@Service
public class TransactionService {

    @Autowired
    private JpaRepository jpaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional
    public void performTransaction() {
        // 操作MySQL
        jpaRepository.save(new Entity());

        // 操作MongoDB
        mongoTemplate.save(new MongoEntity(), "collection");

        // 如果需要回滚，抛出异常
        throw new RuntimeException("回滚数据库操作");
    }
}
确保你的MySQL和MongoDB配置在同一个Spring Boot项目中，并且已经配置好JPA和MongoDB的支持。当performTransaction()方法中的代码抛出异常时，两个数据源的操作都会同时回滚。

注意：ChainedTransactionManager不是Spring Boot或Spring Data提供的实际类，你需要实现一个自定义的事务管理器来同时管理MySQL和MongoDB的事务。如果你使用的是两个独立的数据库，你可能需要编写自定义的事务管理逻辑来协调它们的事务。