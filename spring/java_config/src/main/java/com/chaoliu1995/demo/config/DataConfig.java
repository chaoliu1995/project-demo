package com.chaoliu1995.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/config.properties")
@EnableTransactionManagement
public class DataConfig implements EnvironmentAware {

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }

    /**
     * 数据库连接池配置
     * @return
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.userName"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("db.initialSize")));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("db.maxActive")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("db.minIdle")));
        dataSource.setMaxWait(Long.parseLong(env.getProperty("db.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("db.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("db.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(env.getProperty("db.validationQuery"));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("db.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("db.testOnReturn")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("db.testWhileIdle")));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("db.poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("db.maxPoolPreparedStatementPerConnectionSize")));
        return dataSource;
    }

    /**
     * sqlSessionFactory配置
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/chaoliu1995/demo/mapper/impl/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.chaoliu1995.demo.entity");
        return sqlSessionFactoryBean;
    }

    /**
     * 自动扫描所有的 Mapper 接口与文件
     *
     * 项目中使用了一个通用Mapper的第三方工具包，其中也有一个MapperScannerConfigurer
     * 第三方：tk.mybatis.spring.mapper.MapperScannerConfigurer
     * 官方：org.mybatis.spring.mapper.MapperScannerConfigurer
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.chaoliu1995.demo.mapper,com.isscas.ucqcs.common.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        Properties properties = new Properties();
        properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

    /**
     * 事务管理器
     *
     * AbstractPlatformTransactionManager 实现了 PlatformTransactionManager 接口
     * DataSourceTransactionManager 继承了 AbstractPlatformTransactionManager
     *
     * 所以在返回类型处使用DataSourceTransactionManager 或 PlatformTransactionManager 并无区别
     *
     * @return
     */
    @Bean
    @Qualifier("defaultTm")
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
