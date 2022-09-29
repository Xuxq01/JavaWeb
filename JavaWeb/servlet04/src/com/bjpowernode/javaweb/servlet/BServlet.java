package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
/*
ServletContext
1.ServletContext是什么?
    ServletContext是接口,是Servlet规范中的一员
2.ServletContext是谁实现的?
    Tomcat服务器(WEB服务器),实现了ServletContext接口
3.ServletContext对象是谁创建的?在什么时候创建的?
    ServletContext在服务器启动的时候创建
    ServletContext对象是WEB服务器创建的
    对于一个webapp来说,ServletContext对象只有一个
    ServletContext对象在服务器关闭的时候销毁
4.ServletContext怎么理解?
    ServletContext对应的其实就是整个web.xml文件
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是:" + application + "<br>");

        //log
        application.log("大家好,我是大学生,欢迎大家一起学习");

        int age = 17;
        //年龄小于18的时候表示非法,记录日志
        if(age < 18){
            application.log("未成年访问!!!",new RuntimeException("未成年禁止访问"));
        }

        //取出来
        Object userObj = application.getAttribute("userObj");
        //输出到浏览器
        out.print(userObj + "<br>");
    }
}
