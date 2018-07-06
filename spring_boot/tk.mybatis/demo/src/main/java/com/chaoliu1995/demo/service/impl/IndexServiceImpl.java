package com.chaoliu1995.demo.service.impl;

import com.chaoliu1995.demo.entity.User;
import com.chaoliu1995.demo.mapper.UserMapper;
import com.chaoliu1995.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2018/4/25 14:09
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
