package com.chaoliu1995.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.chaoliu1995.demo.dao.ExampleDao;
import com.chaoliu1995.demo.entity.Example;

@Component("exampleDao")
public class ExampleDaoImpl implements ExampleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveExample(Example example) {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("insert into example (name) value('");
		sqlStr.append(example.getName());
		sqlStr.append("') ");
		jdbcTemplate.execute(sqlStr.toString());
	}
	
	
}
