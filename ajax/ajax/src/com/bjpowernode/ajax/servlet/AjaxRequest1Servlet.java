package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxrequest1")
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Servlet向浏览器响应一段数据
        PrintWriter out = response.getWriter();

        //out像浏览器输出信息
        //服务器代码实际上和以前还是一样的,浏览器客户端的XMLHttpRequest对象会接收到这个响应的信息
        out.print("<font color='red'>welcome study ajax</font>");
    }
}
