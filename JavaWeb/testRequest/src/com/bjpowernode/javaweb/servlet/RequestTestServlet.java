package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class RequestTestServlet extends HttpServlet {
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取参数Map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            //System.out.println(key);
            //通过key获取value
            String[] values = parameterMap.get(key);
            //System.out.println(key + "=" + values);
            System.out.print(key + "=");
            for(String value:values){
                System.out.print(value + ",");
            }
            System.out.println();
        }

        //直接通过getParameterNames()这个方法,可以获取集合Map集合的所有key
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name);
        }

        //直接通过name获取value这个一维数组
        String[] usernames = request.getParameterValues("username");
        String[] userpwds = request.getParameterValues("userpwd");
        String[] interests = request.getParameterValues("interest");

        //遍历一维数组
        for(String username:usernames){
            System.out.println(username);
        }
        for(String password:userpwds){
            System.out.println(password);
        }
        for(String interest:interests){
            System.out.println(interest);
        }

        //通过name获取value这个一维数组的第一个元素(这个方法使用最多,因为一维数组中一般只有一个元素)
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String interest = request.getParameter("interest");

        System.out.println(username);
        System.out.println(userpwd);
        System.out.println(interest);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();*/

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取客户端的ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户端的ip地址: " + remoteAddr);

    }*/
}
