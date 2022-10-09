package com.bjpowernode.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:验证用户名是否可用
 * @USER: 11240
 * @DATE: 2022/10/8 19:07
 */
@WebServlet("/ajaxrequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag= false;
        String username = request.getParameter("username");

        //连接数据库验证用户名是否存在
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC","root","333");
            String sql = "select username,password from t_user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(username == ""){
            out.print("<font color='red'>用户名不能为空</font>");
        }else if(flag){
            //用户名已存在
            out.print("<font color='red'>用户名已存在</font>");
        }else{
            out.print("<font color='green'>用户名可以使用</font>");
        }
    }
}
