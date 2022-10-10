package com.bjpowernode.b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpClient;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:
 * @USER: 11240
 * @DATE: 2022/10/9 18:43
 */
@WebServlet("/user/reg")
public class UserRegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.getWriter().print(username + "," + password);
    }
}
