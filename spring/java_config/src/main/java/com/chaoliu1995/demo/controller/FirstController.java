package com.chaoliu1995.demo.controller;

import com.chaoliu1995.demo.entity.User;
import com.chaoliu1995.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	public User getUser() {
		return userService.getUser();
	}
	
	@RequestMapping(value = "/getFirstUser", method = RequestMethod.POST)
	@ResponseBody
	public User getFirstUser() {
		return userService.getFirstUser();
	}
}
