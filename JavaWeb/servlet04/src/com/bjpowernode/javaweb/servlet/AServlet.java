package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是:" + application + "<br>");

        //获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        //获取context path(获取应用上下文的根)
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br>");

        //String realPath = application.getRealPath("/index.html");//index前的'/'可加可不加
        //out.print(realPath + "<br>");//路径加了'/'表示的是web的根,不加'/'默认也是从根下开始找

        //FileInputStream inputStream = new FileInputStream(realPath);

        String realPath = application.getRealPath("/common/common.html");
        out.print(realPath + "<br>");

        //准备数据
        User user = new User("jack","123");
        //向ServletContext应用域中存储数据
        application.setAttribute("userObj",user);
        //取出来
        //Object userObj = application.getAttribute("userObj");
        //输出到浏览器
        //out.print(userObj + "<br>");

        //Thread.currentThread().getName();
    }
}

