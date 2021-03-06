package com.chaoliu1995.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaoliu1995.demo.entity.User;
import com.chaoliu1995.demo.mapper.UserMapper;
import com.chaoliu1995.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getFirstUser() {
		return userMapper.getFirstUser();
	}

	@Override
	public User getUser() {
		return userMapper.getUser();
	}
	
	
}
