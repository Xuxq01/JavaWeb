package com.bjpowernode.javaweb.bean;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

//普通java类,实现了HttpSessionBindingListener接口
public class User1 implements HttpSessionBindingListener {
    private String usercode;
    private String username;
    private String password;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定数据");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑数据");
    }

    public User1() {
    }

    public User1(String usercode, String username, String password) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
