package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie = new Cookie("productid","21531293613213");
        Cookie cookie2 = new Cookie("username","zhangsan");

        //设置cookie在一小时之后失效(保存在硬盘文件当中)
        //cookie.setMaxAge(60 * 60);

        //设置cookie的有效期为0,表示该cookie删除,主要应用在使用这个方式删除同名cookie
        //cookie.setMaxAge(0);

        //设置cookie的有效期小于0,表示该cookie不会被存储
        cookie.setMaxAge(-1);//和不调用setMaxAge()一样
        cookie2.setMaxAge(-1);

        //默认情况下,没有设置path的时候,cookie关联的路径是什么
        cookie.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());

        //将cookie响应到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }
}
