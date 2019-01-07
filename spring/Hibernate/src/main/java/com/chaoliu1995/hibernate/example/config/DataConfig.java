package com.chaoliu1995.hibernate.example.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

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
	 * DBCP数据库连接池配置
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
	
	/**
	 * sqlSessionFactory配置
	 * @param dataSource
	 * @return
	 * @throws IOException
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) throws IOException{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Properties pps = new Properties();
		String path = DataConfig.class.getResource("/")+"hibernate.properties";
		path = path.substring(6, path.length());
		pps.load(new BufferedInputStream (new FileInputStream(path)));
		sessionFactory.setHibernateProperties(pps);
		sessionFactory.setPackagesToScan(new String[]{"com.chaoliu1995.hibernate.example.entity"});
		return sessionFactory;
	}
	
	/**
	 * 事务管理器
	 * @return
	 */
	@Bean
	@Qualifier("defaultTm")
	public HibernateTransactionManager txManager(SessionFactory sessionFactory){
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
