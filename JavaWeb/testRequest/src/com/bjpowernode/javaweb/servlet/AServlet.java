package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date nowTime = new Date();
        request.setAttribute("sysTime",nowTime);
        //Object sysTime = request.getAttribute("sysTime");

        //System.out.println(sysTime);

        //这样做可以吗?
        //在AServlet当中new一个BServlet对象,然后调用BServlet对象的doGet方法,把request对象传过去
        //代码可以实现功能,但Servlet对象不能由程序员自己new,自己new出来的Servlet对象不受Tomcat服务器管理
        /*BServlet bServlet = new BServlet();
        bServlet.doGet(request,response);*/

        //使用Servlet当中的转发机制
        //执行了AServlet之后,跳转到BServlet
        //怎么转发?第一步:获取请求转发器对象,相当于把/b这个路径包装到请求转发器中,实际上是把下一个跳转的资源的路径告知Tomcat服务器
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
        //第二步:调用请求转发器DisPatcher的forward()方法
        //转发的时候,这连个参数很重要,request和response要传递给下一个资源
        //dispatcher.forward(request,response);

        request.getRequestDispatcher("/b").forward(request,response);
        //只要是web容器中的合法资源就可以转发
        //request.getRequestDispatcher("/test.html").forward(request,response);
    }
}
