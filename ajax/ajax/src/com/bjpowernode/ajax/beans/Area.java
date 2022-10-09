package com.bjpowernode.ajax.beans;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION: 区域
 * @USER: 11240
 * @DATE: 2022/10/9 16:24
 */
public class Area {
    private String code;
    private String name;

    public Area() {
    }

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
