package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/a.do")
//@WebFilter({"/a.do","/b.do"})

//以下这个路径属于模糊匹配中的扩展匹配,以星号开始,注意不要以"/"开始
@WebFilter("*.do")

//*属于前缀匹配,要以"/"开始
//@WebFilter("/dept/*")

//匹配所有的路径
//@WebFilter("/*")
public class Filter1 implements Filter {
    public Filter1(){
        System.out.println("无参构造方法执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init方法执行");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("doFilter方法开始执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter方法执行结束");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy方法执行");
    }
}
