package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//当注解的属性是一个数组且数组中只有一个元素,大括号可以省略
//value属性和urlPatterns属性一致
//value和urlPatterns属性是一致的(这两个不能同时出现),都是用来指定Servlet的映射路径的
//如果注解属性名是value的话,属性名可以不写
@WebServlet({"/welcome","/abc","/def"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("欢迎学习servlet");
    }
}
