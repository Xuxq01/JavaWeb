package com.bjpowernode.template1;

public class Student {
    public void day(){
        //和Teacher相同
        wakeUp();
        bath();
        eatBrk();
        doSome();
        eatDir();
        sleep();
    }

    public void wakeUp(){
        System.out.println("起床");
    }

    public void bath(){
        System.out.println("洗漱");
    }

    public void eatBrk(){
        System.out.println("吃早餐");
    }

    public void doSome(){
        System.out.println("学生上学,学习");
    }

    public void eatDir(){
        System.out.println("吃晚饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}
