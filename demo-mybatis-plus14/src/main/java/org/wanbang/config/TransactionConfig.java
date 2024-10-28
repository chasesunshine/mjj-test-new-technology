package org.wanbang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class TransactionConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MongoDatabaseFactory mongoDbFactory;

    @Bean
    public PlatformTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public PlatformTransactionManager mongoTransactionManager() {
        return new MongoTransactionManager(mongoDbFactory);
    }

    @Bean
    public ChainedTransactionManager transactionManager() {
        return new ChainedTransactionManager(mysqlTransactionManager(), mongoTransactionManager());
    }
}
