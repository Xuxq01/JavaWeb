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
 * @DATE: 2022/10/9 22:23
 */
@WebServlet("/jsonp2")
public class JsonpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fun = request.getParameter("fun");
        response.getWriter().print(fun + "{\"username\" : \"zhangsan\"}");
    }
}
