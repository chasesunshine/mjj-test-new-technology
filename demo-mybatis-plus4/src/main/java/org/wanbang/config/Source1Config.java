package org.wanbang.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/24 19:08
 * @version 1.0
 */

@Configuration
@MapperScan(basePackages = "org.wanbang.dao.source1dao", sqlSessionFactoryRef = "source1SqlSessionFactory")
public class Source1Config {

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.source1")
    @Bean("source1DataSource")
    public DataSource mysqlDataSource(DataSourceProperties properties){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("source1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("source1DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/mapper1/*Dao.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("source1TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("source1DataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

//    @Bean("source1SqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("source1SqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//        return sqlSessionTemplate;
//    }
}