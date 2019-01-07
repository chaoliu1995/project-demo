package com.chaoliu1995.hibernate.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 总的配置类
 * @author Administrator
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.chaoliu1995.hibernate.example" })
@Import({ DataConfig.class })
public class AppConfig {
	
	
}
