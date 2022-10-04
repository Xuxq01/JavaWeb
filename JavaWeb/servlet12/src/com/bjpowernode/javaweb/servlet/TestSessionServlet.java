package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request对象代表了一次请求,一次请求就对应了一个request对象
        //session对象代表了一次会话,一次会话就对应了一个session对象
        //获取session对象
        HttpSession session = request.getSession();
        //向会话域当中绑定数据
        //session.setAttribute();
        //从会话域中取数据
        //Object obj = session.getAttribute();

        //将session对象响应到浏览器
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("session对象:" + session);

    }
}
