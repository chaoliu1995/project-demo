package com.chaoliu1995.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.chaoliu1995.demo.aop.TransactionManagerAOP;

@Configuration
@PropertySource("classpath:/config.properties")
@ComponentScan(basePackages={"com.chaoliu1995.demo.service.impl", "com.chaoliu1995.demo.dao.impl"})
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Autowired
	private Environment env;
	
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
		dataSource.setInitialSize(env.getProperty("db.initialSize",Integer.class));
		dataSource.setMaxActive(env.getProperty("db.maxActive",Integer.class));
		dataSource.setMinIdle(env.getProperty("db.minIdle",Integer.class));
		dataSource.setMaxWait(env.getProperty("db.maxWait",Long.class));
		dataSource.setTimeBetweenEvictionRunsMillis(env.getProperty("db.timeBetweenEvictionRunsMillis",Long.class));
		dataSource.setMinEvictableIdleTimeMillis(env.getProperty("db.minEvictableIdleTimeMillis",Long.class));
		dataSource.setValidationQuery(env.getProperty("db.validationQuery"));
		dataSource.setTestOnBorrow(env.getProperty("db.testOnBorrow",Boolean.class));
		dataSource.setTestOnReturn(env.getProperty("db.testOnReturn",Boolean.class));
		dataSource.setTestWhileIdle(env.getProperty("db.testWhileIdle",Boolean.class));
		dataSource.setPoolPreparedStatements(env.getProperty("db.poolPreparedStatements",Boolean.class));
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(env.getProperty("db.maxPoolPreparedStatementPerConnectionSize",Integer.class));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	@Bean
	public TransactionManagerAOP transactionManagerAOP(){
		return new TransactionManagerAOP();
	}
}
