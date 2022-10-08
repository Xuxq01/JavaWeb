package com.bjpowernode.javaweb.servlet;

public class Test2 {
    //静态代码块:在类加载时执行,并且只执行一次
    //静态代码块什么时候使用?
    //是否需要在类加载时执行一段代码
    //静态代码块是java语言预留的一个特殊的时机,这个时机叫做:类加载时机
    static{
        System.out.println("类加载了");
    }

    //入口
    public static void main(String[] args) {

    }
}
