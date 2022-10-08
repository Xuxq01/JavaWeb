package com.bjpowernode.javaweb.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;


//@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    //向session域当中存储数据的时候,以下方法被服务器调用
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session data add");
    }

    //向session域当中删除数据的时候,以下方法被服务器调用
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session data remove");
    }

    //向session域当中替换数据的时候,以下方法被服务器调用
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session data replace");
    }
}
