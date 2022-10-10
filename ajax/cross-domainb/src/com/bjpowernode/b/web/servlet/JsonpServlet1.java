package com.bjpowernode.b.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.XMLFormatter;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:
 * @USER: 11240
 * @DATE: 2022/10/9 21:52
 */
@WebServlet("/jsonp1")
public class JsonpServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //在后台输出
        //System.out.println("jsonp方式完成跨域访问");

        //向前端响应一段js代码呢?
        PrintWriter out = response.getWriter();
        //out.print("alert(123)");
        //out.print("sayHello()");

        //响应一段js代码,传一个json数据给前端
        out.print("sayHello({\"name\" : \"jackson\"})");
    }
}
