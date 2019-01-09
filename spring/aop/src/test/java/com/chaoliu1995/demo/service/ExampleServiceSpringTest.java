package com.chaoliu1995.demo.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.chaoliu1995.demo.base.BaseJunit4Test;
import com.chaoliu1995.demo.entity.Example;

public class ExampleServiceSpringTest extends BaseJunit4Test {
	
	@Resource
	private ExampleService exampleService;
	
	@Test
	public void testSaveExample(){
		Example example = new Example();
		example.setName("李四");
		exampleService.saveExample(example);
	}
	
}
