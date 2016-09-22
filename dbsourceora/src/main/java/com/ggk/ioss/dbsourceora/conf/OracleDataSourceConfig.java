package com.ggk.ioss.dbsourceora.conf;

import java.beans.PropertyVetoException;

import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(OracleDataSourceProperties.class)
@MapperScan("com.ggk.ioss.dbsourceora.mapper")
public class OracleDataSourceConfig {
    private static final String MYBATIS_CONFIG_PATH= "classpath:mybatis-config.xml";
    
    @Autowired
    private OracleDataSourceProperties dataSourceProperties;
    private DataSource dataSource;
    
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        dataSource = new DataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDiverClassName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        if(dataSourceProperties.getUsername() != null) {
            dataSource.setUsername(dataSourceProperties.getUsername());
        }
        if(dataSourceProperties.getPassword() != null) {
            dataSource.setPassword(dataSourceProperties.getPassword());
        }
        dataSource.setInitialSize(dataSourceProperties.getInitialSize());
        dataSource.setMaxActive(dataSourceProperties.getMaxActive());
        dataSource.setMaxIdle(dataSourceProperties.getMaxIdle());
        dataSource.setMinIdle(dataSourceProperties.getMinIdle());
        dataSource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ggk.ioss.dbsourceora.model");
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(MYBATIS_CONFIG_PATH));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }
    
    @PreDestroy
    public void close() {
        if (dataSource != null) {
            dataSource.close();
            dataSource = null;
        }
    }
}

