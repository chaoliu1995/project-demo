package com.chaoliu1995.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chaoliu1995.demo.entity.User;
import com.chaoliu1995.demo.service.UserService;

public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserService userService = new UserService();
		List<User> userList  = userService.listUser();
		request.setAttribute("username", userList.get(0).getUsername());
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request,response);
	}

}
