package com.bjpowernode.oa.servlet.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
/*
    处理订单相关业务的类
    需要先登录才能处理
*/
public class OrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("username") != null){
            String servletPath = request.getServletPath();
            //......
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }*/
    }
}
