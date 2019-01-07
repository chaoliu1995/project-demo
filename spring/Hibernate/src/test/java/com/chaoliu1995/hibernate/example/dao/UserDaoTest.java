package com.chaoliu1995.hibernate.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaoliu1995.hibernate.example.base.BaseJunit4Test;
import com.chaoliu1995.hibernate.example.entity.User;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午6:43:45
*/
public class UserDaoTest extends BaseJunit4Test {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSaveAll(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		User userB = new User();
		userB.setUsername("adminB");
		userB.setPassword("1345678");
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(userB);
		userDao.saveAll(list);
	}
	
}
