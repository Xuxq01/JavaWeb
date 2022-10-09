package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION: 测试自己写的jQuery类
 * @USER: 11240
 * @DATE: 2022/10/9 15:43
 */
@WebServlet("/ajaxrequest11")
public class AjaxRequest11Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        //{"uname" : "zhangsan"}
        response.getWriter().print("{\"uname\" : \""+username.toUpperCase(Locale.ROOT)+"\"}");
    }
}
