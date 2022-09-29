package com.bjpowernode.javaweb.servlet.servlet.ConfigTestServlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
    ServletConfig
        1.ServletConfig是什么?
            jakarta.servlet.ServletConfig
            显然servletConfig是servlet规范中的一员
            ServletConfig是一个接口,(jakarta.servlet.Servlet是一个接口)
        2.谁去实现了这个接口呢?
        结论:Tomcat实现了ServletConfig这个接口
        3.一个Servlet对象中就有一个ServletConfig对象(一对一)
        4.ServletConfig对象是谁创建的?在什么时候创建的?
        Tomcat服务器(WEB服务器)创建了ServletConfig对象
        创建Servlet对象的同时创建了ServletConfig对象
        5.ServletConfig接口到底是干啥的?有什么用呢?
        Config是Configuration的缩写
        ServletConfig对象被翻译为:Servlet对象的配置信息对象
        一个Servlet对象,就有一个配置信息对象
        6.ServletConfig对象到底包装了什么信息呢?
        <servlet>
            <servlet-name>configTest</servlet-name>
            <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet.ConfigTestServlet</servlet-class>
        </servlet>
        ServletConfig对象包装的信息是:
            web.xml文件中<servlet></servlet>标签的配置信息自动包装到ServletConfig对象中
        7.ServletConfig接口中有哪些方法?
        <servlet>
                <servlet-name>configTest</servlet-name>
                <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet.ConfigTestServlet</servlet-class>
            <init-param>
                <param-name>driver</param-name>
                <param-value>com.mysql.jdbc.Driver</param-value>
            </init-param>
            <init-param>
                <param-name>url</param-name>
                <param-value>jdbc:mysql://localhost:3306/bjpowernode</param-value>
            </init-param>
            <init-param>
                <param-name>user</param-name>
                <param-value>root</param-value>
            </init-param>
            <init-param>
                <param-name>password</param-name>
                <param-value>333</param-value>
            </init-param>
        </servlet>
        以上<servlet></servlet>标签中的<init-param></init-param>是初始化参数,这个初始化参数会自动被Tomcat封装到Servlet对象中
        8.ServletConfig接口中有四个方法
            public String getInitParameter(String name);
            public Enumeration<String> getInitParameterNames();
            public ServletContext getServletContexts();
            public String getServletName();
 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取Servlet对象
        ServletConfig config = this.getServletConfig();
        //输出该对象     ServletConfig对象是: org.apache.catalina.core.StandardWrapperFacade@1d88771c
        out.print("ServletConfig对象是: " + config);

        //获取<servlet-name></servlet-name>
        String servletName = config.getServletName();
        out.print("<br>");
        out.print(servletName);
        out.print("<br>");

        //通过ServletConfig对象的两个方法,可以获取到web.xml文件中的初始化参数配置信息
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //遍历集合
        while(initParameterNames.hasMoreElements()){
            String parameterName = initParameterNames.nextElement();
            String parameterVal = config.getInitParameter(parameterName);//通过name获取value
            out.print(parameterName + "=" + parameterVal);
            out.print("<br>");
        }

        //通过初始化参数的name获取value
        //String driver = config.getInitParameter("driver");
        //out.print(driver);

        //实际上获取Servlet对象的初始化参数,可以不用获取ServletConfig对象,直接通过this也可以
        Enumeration<String> names = this.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            //打印到后台
            System.out.println(name + "=" + value);
        }

        //通过ServletConfig对象获取ServletContext
        ServletContext application = config.getServletContext();
        //输出
        out.print("<br>" + application);//org.apache.catalina.core.ApplicationContextFacade@37cdb83
        //通过this也可以获取ServletContext对象
        ServletContext application2 = this.getServletContext();
        out.print("<br>" + application2);//org.apache.catalina.core.ApplicationContextFacade@37cdb83
    }
}
