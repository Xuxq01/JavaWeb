package jdbc.util;

import java.sql.*;

/*
JDBC工具类:简化JDBC编程
 */
public class DBUtil {
    /*
    工具类中的构造方法都是私有的
    因为工具类当中的个方法都是静态的,不需要new对象,直接采用类名调用
     */
    private DBUtil() {
    }

    static{
        //静态代码块,在类加载时执行,并且只执行一次
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","QIan20030625");
    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
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
