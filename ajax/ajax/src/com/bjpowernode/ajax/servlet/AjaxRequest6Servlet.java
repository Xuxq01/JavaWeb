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
 * @DESCRIPTION:服务器返回XML字符串
 * @USER: 11240
 * @DATE: 2022/10/8 22:26
 */
@WebServlet("/ajaxrequest6")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //注意响应的类型是XML
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /*
        <students>
            <student>
                <name>张三</name>
                <age>20</age>
            </student>
            <student>
                <name>李四</name>
                <age>22</age>
            </student>
        </students>
         */

        StringBuilder xml = new StringBuilder();
        xml.append("<students>");
        xml.append("    <student>");
        xml.append("        <name>张三</name>");
        xml.append("        <age>20</age>");
        xml.append("    </student>");
        xml.append("    <student>");
        xml.append("        <name>李四</name>");
        xml.append("        <age>22</age>");
        xml.append("    </student>");
        xml.append("</students>");

        out.print(xml);
    }
}
