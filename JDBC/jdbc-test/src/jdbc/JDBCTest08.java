package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest08 {
    public static void main(String[] args) {
/*        //用户在控制台输入desc就是降序,输入asc就是升序
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc/asc:");
        String keyWords = s.nextLine();

        //执行sql
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
            String sql = "select ename from emp order by ename ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyWords);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/

        //用户在控制台输入desc就是降序,输入asc就是升序
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc/asc:");
        String keyWords = s.nextLine();

        //执行sql
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
            stmt = conn.createStatement();
            String sql = "select ename from emp order by ename " + keyWords;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
