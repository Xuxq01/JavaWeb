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
 * @DESCRIPTION: 将Ajax请求封装到jQuery当中
 * @USER: 11240
 * @DATE: 2022/10/9 11:33
 */
@WebServlet("/ajaxrequest10")
public class AjaxRequest10Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.print("{\"uname\" : \""+username+"\"}");
    }
}
