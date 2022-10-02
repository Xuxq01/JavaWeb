package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;

import java.lang.annotation.Annotation;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception {
        //使用反射机制将类上面的注解进行解析
        //获取类Class对象
        Class<?> welcomeServletClass = Class.forName("com.bjpowernode.javaweb.servlet.WelcomeServlet");

        //获取类上的注解对象
        //先判断类上面有没有注解对象
        //boolean annotationPresent = welcomeServletClass.isAnnotationPresent(WebServlet.class);
        //System.out.println(annotationPresent);

        if(welcomeServletClass.isAnnotationPresent(WebServlet.class)){
            WebServlet webServletAnnotation = welcomeServletClass.getAnnotation(WebServlet.class);
            //获取注解的value属性值
            String[] value = webServletAnnotation.value();
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        }
    }
}
