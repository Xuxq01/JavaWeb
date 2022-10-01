package com.bjpowernode.javaweb.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置请求体的字符集,对get无效,因为在请求行
        //Tomcat10之后,request请求体字符集默认就是UTF-8,不需要设置,不会出现乱码
        request.setCharacterEncoding("UTF-8");
        //获取用户提交的用户名
        String username = request.getParameter("username");
        //输出username
        System.out.println(username);

        //加";charset=UTF-8"可以解决输出到浏览器(响应)乱码问题
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("大家好,我是java练习生");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realname = request.getParameter("realname");
        System.out.println(realname);
    }
}