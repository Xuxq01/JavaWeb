package com.bjpowernode.javaweb.servlet.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class LoginServlet extends GenericServlet{

    //思考一个问题:
    //有没有可能:需要在LoginServlet中重写init方法?
    //当然有可能

    //父类将原始的init方法final了,子类没办法重写init方法了
    //如果这个时候还希望重写init方法呢?

    //这个方法是供子类重写的
    @Override
    public void init(){
        System.out.println("LoginServlet's init() method execute!");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("正在处理用户登录请求,请稍后......");
        //想在loginServlet子类中使用ServletConfig对象怎么办?
        ServletConfig config = this.getServletConfig();
        System.out.println("service方法中可以获取到ServletConfig对象" + config);
    }
}
