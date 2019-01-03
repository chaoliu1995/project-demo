package com.chaoliu1995.demo.service;

import java.util.List;

import com.chaoliu1995.demo.dao.UserDao;
import com.chaoliu1995.demo.entity.User;

public class UserService {
	
	public List<User> listUser(){
		List<User> userList = null;
		try {
			UserDao userDao = new UserDao();
			userList = userDao.listUser();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
}
