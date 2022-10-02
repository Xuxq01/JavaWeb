package com.bjpowernode.oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        if(username.equals("root") && userpwd.equals("333")){
            request.getRequestDispatcher("/index.html").forward(request,response);
        }else{
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
