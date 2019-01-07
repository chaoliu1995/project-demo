package com.chaoliu1995.hibernate.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.chaoliu1995.hibernate.example.base.impl.BaseDaoImpl;
import com.chaoliu1995.hibernate.example.dao.UserDao;
import com.chaoliu1995.hibernate.example.entity.User;

/** 
* @Author: ChaoLiu
* @Description: 
* @Email: chaoliu1995@qq.com
* @CreateDate: 2017年12月17日 下午6:42:24
*/
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
}
