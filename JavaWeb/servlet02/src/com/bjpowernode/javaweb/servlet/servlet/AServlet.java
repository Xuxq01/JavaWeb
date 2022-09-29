package com.bjpowernode.javaweb.servlet.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {

    //无参构造方法
    public AServlet() {
        System.out.println("AServlet无参构造方法执行了");
    }

    //init为初始化
    //只执行一次
    //在Servlet对象第一次被创建之后执行
    //init方法通常是完成初始化工作的
    //init方法执行的时候AServlet方法已经被创建出来了
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Aservlet's init method execute");
    }

    //service方法:处理用户请求的核心方法
    //只要用户发送一次请求,service方法就必然会执行一次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execute");
    }

    //destory方法只执行一次
    //Tomcat服务器在销毁AServlet对象之前会调用一次destory方法
    //destory方法在执行的时候,AServlet方法没被销毁,即将被销毁
    //destory方法中可以编写销毁前的准备
    //比如说:服务器关闭的时候,AServlet对象开启了一些资源,可能是流或数据库连接
    //那么关闭服务器的时候,要关闭这些流,数据库链接,关闭的代码可以写在destory中
    @Override
    public void destroy() {
        System.out.println("AServlet's destory method execute");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
