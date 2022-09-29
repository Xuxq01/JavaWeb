package com.bjpowernode.javaweb.servlet.servlet.ConfigTestServlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        ServletConfig config = this.getServletConfig();
        out.print("ServletConfig对象: " + config);
        //ServletConfig对象: org.apache.catalina.core.StandardWrapperFacade@64b52f47

        String value = config.getInitParameter("key");
        out.print("<br>" + value);
    }
}
