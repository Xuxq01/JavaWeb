package com.bjpowernode.oa.servlet.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        /*什么情况下不能拦截?
            目前写的路径是/*,表示所有请求均拦截
            用户访问index.jsp的时候不能拦截
            用户已经/要去登录不能拦截
            WelcomeServlet也不能拦截
         */

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp ;

        String servletpath = request.getServletPath();

        HttpSession session = request.getSession(false);
        if("/index.jsp".equals(servletpath) || "/welcome".equals(servletpath) ||
                "/user/login".equals(servletpath) ||
                (session != null && session.getAttribute("user") != null)){
            //继续往下走
            chain.doFilter(request,response);
        }else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
