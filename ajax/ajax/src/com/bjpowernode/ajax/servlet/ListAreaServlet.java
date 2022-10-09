package com.bjpowernode.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.ajax.beans.Area;
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
 * @DESCRIPTION: 动态获取对应区域
 * @USER: 11240
 * @DATE: 2022/10/9 16:18
 */
@WebServlet("/listArea")
public class ListAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pcode = request.getParameter("pcode");

        //连接数据库获取所有的对应区域,最后响应一个json格式的字符串给WEB前端
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Area> areaList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bjpowernode";
            String user = "root";
            String password = "333";
            conn = DriverManager.getConnection(url,user,password);
            String sql = "";
            if(pcode == null) {
                sql = "select code,name from t_area where pcode is null";
                ps = conn.prepareStatement(sql);
            }else{
                sql = "select code,name from t_area where pcode = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,pcode);
            }

            rs = ps.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                Area a = new Area(code,name);
                areaList.add(a);
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
        PrintWriter out = response.getWriter();
        //使用fastjson
        String json = JSON.toJSONString(areaList);
        out.print(json);
    }
}
