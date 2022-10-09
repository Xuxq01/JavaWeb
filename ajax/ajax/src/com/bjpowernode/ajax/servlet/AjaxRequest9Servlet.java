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
 * @DESCRIPTION: 测试Ajax同步和异步
 * @USER: 11240
 * @DATE: 2022/10/9 9:30
 */
@WebServlet("/ajaxrequest9")
public class AjaxRequest9Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("ajax请求2");
    }
}
