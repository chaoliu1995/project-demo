package com.chaoliu1995.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaoliu1995.demo.dao.ExampleDao;
import com.chaoliu1995.demo.entity.Example;
import com.chaoliu1995.demo.service.ExampleService;

@Component("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	@Autowired
	private ExampleDao exampleDao;
	
	@Override
	public void saveExample(Example example) {
		exampleDao.saveExample(example);
	}
	
}
