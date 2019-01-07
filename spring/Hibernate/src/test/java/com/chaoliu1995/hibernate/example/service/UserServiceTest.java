package com.chaoliu1995.hibernate.example.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaoliu1995.hibernate.example.base.BaseJunit4Test;
import com.chaoliu1995.hibernate.example.entity.User;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午6:35:31
*/
public class UserServiceTest extends BaseJunit4Test {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testSave(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		userService.save(user);
	}
	
}
