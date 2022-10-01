package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //org.apache.catalina.connector.RequestFacade@5719fe24
        out.print(request);

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);*/

        //这个方法使用比较多(动态获取应用的根路径)
        String contextPath = request.getContextPath();
        System.out.println("应用的根路径: " + contextPath);

        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);

        // 获取请求的URI
        String uri = request.getRequestURI();
        System.out.println(uri);

        // 获取servlet path
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(request);
    }*/


}
