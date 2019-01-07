package com.chaoliu1995.hibernate.example.service.impl;

import org.springframework.stereotype.Service;

import com.chaoliu1995.hibernate.example.base.impl.BaseServiceImpl;
import com.chaoliu1995.hibernate.example.entity.User;
import com.chaoliu1995.hibernate.example.service.UserService;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午6:33:38
*/
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
}
