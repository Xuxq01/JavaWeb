package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:测试Ajax乱码问题
 * @USER: 11240
 * @DATE: 2022/10/8 23:10
 */
@WebServlet("/ajaxrequest7")
public class AjaxRequest7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收的中文会不会乱码?
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会有乱码吗?
        PrintWriter out = response.getWriter();
        out.print(username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //接收的中文会不会乱码?
        String username = request.getParameter("username");
        System.out.println(username);
        //响应中文会有乱码吗?
        PrintWriter out = response.getWriter();
        out.print(username);
    }
}
