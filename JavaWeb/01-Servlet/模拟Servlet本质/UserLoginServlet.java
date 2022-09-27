package com.bjpowernode.servlet;

import javax.servlet.Servlet;
//充当的角色webapp开发者
public class UserLoginServlet implements Servlet{
	public void service(){
		System.out.println("UserLoginServlet's Service...");
	}
}