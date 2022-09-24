package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    JDBC事务机制
        1.JDBC中的事务是自动提交的
            只要执行任意一条DML语句,则自动提交一次,这是JDBC默认的事务行为
            但是在实际业务中,通常都是N条DML语句共同联合才能完成的,必须
            保证他们这些DML语句在同一个事物中必须同时成功或同时失败
        2.以下程序先来验证JDBC的事务是否是自动提交机制
 */
public class JDBCTest10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");

            String sql = "update dept set dname = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"x");
            ps.setInt(2,30);

            int count = ps.executeUpdate();
            System.out.println(count);
            //重新给占位符传值
            ps.setString(1,"y");
            ps.setInt(2,20);
            count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
}
