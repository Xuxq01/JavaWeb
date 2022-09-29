package com.bjpowernode.javaweb.servlet.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.ObjectInputFilter;

/*
编写一个标准通用的Servlet,起名:GenericServlet
以后所有的Servlet类都不要直接实现Servlet接口
以后所有的类都要继承GenericServlet
这就是一个适配器
 */
public abstract class GenericServlet implements Servlet {
    private ServletConfig config;
    /*
    init方法中的ServletConfig对象是Tomcat创建好的
    这个ServletConfig对象目前在init方法的参数上,属于局部变量
    那么ServletConfig对象以后肯定要在service方法中使用,怎么才能保证能使用呢?
     */
    @Override
    public final void init(ServletConfig config) throws ServletException {
        //System.out.println("servletConfig对象:" + config);
        this.config = config;
        this.init();
    }

    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
