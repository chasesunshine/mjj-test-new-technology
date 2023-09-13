package org.dongfu.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(basePackages = "org.wanbang.dao.source2dao", sqlSessionFactoryRef = "source2SqlSessionFactory")
public class Source2Config {

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.source2")
    @Bean("source2DataSource")
    public DataSource mysqlDataSource(DataSourceProperties properties){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("source2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("source2DataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/mapper2/*Dao.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("source2TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("source2DataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }

    @Bean("source2SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("source2SqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}