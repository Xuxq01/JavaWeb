package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //加了ln是源代码换行,不是显示换行,显示需要<br>
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>from get servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>from get servlet</h1>");
        out.println("    </body>");
        out.println("</html>");
    }
}
