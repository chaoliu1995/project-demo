package com.chaoliu1995.demo.service;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chaoliu1995.demo.config.AppConfig;
import com.chaoliu1995.demo.entity.Example;

public class ExampleServiceTest {
	
	@Test
	public void testSaveExample(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ExampleService exampleService = (ExampleService)context.getBean("exampleService");
		Example example = new Example();
		example.setName("zhangsan");
		exampleService.saveExample(example);
		context.close();
	}
	
	@Test
	public void testSaveExampleXML(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExampleService exampleService = (ExampleService)context.getBean("exampleService");
		Example example = new Example();
		example.setName("王五XML");
		exampleService.saveExample(example);
		context.close();
	}
	
}
