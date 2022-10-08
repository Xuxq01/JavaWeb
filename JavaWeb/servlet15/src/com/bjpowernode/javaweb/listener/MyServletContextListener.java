package com.bjpowernode.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;

/*ServletContextListener监听器主要坚挺的是,ServletContext对象的状态*/
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //想在这个特殊的时刻写代码就可以了,是发生某个事件之后被服务器自动调用
        //在ServletContext对象被创建的时候调用
        System.out.println("ServletContext对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //想在这个特殊的时刻写代码就可以了,是发生某个事件之后被服务器自动调用
        //在ServletContext对象被销毁的时候调用
        System.out.println("ServletContext对象销毁了");
    }
}
