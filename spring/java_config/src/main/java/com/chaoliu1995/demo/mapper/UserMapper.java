package com.chaoliu1995.demo.mapper;

import com.chaoliu1995.demo.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	User getFirstUser();
	
	User getUser();
}
