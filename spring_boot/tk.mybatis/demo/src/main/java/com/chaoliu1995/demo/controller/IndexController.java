package com.chaoliu1995.demo.controller;

import com.chaoliu1995.demo.entity.User;
import com.chaoliu1995.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ChaoLiu
 * @Description:
 * @Date: 2018/4/25 11:40
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/user/add")
    public String addUser(){
        User user = new User();
        user.setName("aaa");
        user.setPassword("bbb");
        indexService.insert(user);
        return "success";
    }

}
