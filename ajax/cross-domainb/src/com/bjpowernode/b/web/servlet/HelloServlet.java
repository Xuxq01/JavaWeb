package com.bjpowernode.b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:
 * @USER: 11240
 * @DATE: 2022/10/9 21:40
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置响应头,允许ajax跨域请求
        response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");

        response.getWriter().print("hello ajax!!!");
    }
}
