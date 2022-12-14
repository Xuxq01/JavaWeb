package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
PreparedStatement完成INSERT DELETE UPDATE
 */
public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
            /*String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,60);
            ps.setString(2,"XIAOSHOUBU");
            ps.setString(3,"SHANGHAI");*/

            /*String sql = "update dept set dname=?,loc=? where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"YANFABU");
            ps.setString(2,"BEIJING");
            ps.setInt(3,60);*/

            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,60);

            int count = ps.executeUpdate();
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
