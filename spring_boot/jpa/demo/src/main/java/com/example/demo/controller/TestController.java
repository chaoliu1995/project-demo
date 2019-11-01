package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2019/8/20 16:31
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("getUser")
    public User getUser(){
        return userRepository.findByName("aaa");
    }

}
