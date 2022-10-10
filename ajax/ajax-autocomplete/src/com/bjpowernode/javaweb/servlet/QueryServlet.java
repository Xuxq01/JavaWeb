package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT_NAME: ajax
 * @DESCRIPTION:
 * @USER: 11240
 * @DATE: 2022/10/10 0:27
 */
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keywords = request.getParameter("keywords");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bjpowernode";
            String user = "root";
            String password = "333";
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select content from t_ajax where content like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keywords + "%");
            rs = ps.executeQuery();

            while(rs.next()){
                String content = rs.getString("content");
                sb.append("{\"content\" : \""+ content +"\"},");
            }
        } catch (Exception e) {
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
        response.getWriter().print(sb.subSequence(0, sb.length() - 1) + "]");
    }
}
