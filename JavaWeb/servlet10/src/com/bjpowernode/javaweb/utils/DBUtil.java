package com.bjpowernode.javaweb.utils;

import java.sql.*;
import java.util.ResourceBundle;

/*
JDBC的工具类
 */
public class DBUtil {
    //静态变量,类加载时执行
    //并且是有顺序的,自上而下
    //属性资源文件绑定
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/jdbc");
    //根据属性文件的key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        try {
            //连接数据库的驱动不能写死
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
