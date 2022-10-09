package com.bjpowernode.ajax.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.ajax.beans.Student;
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
 * @DESCRIPTION:发送Ajax请求,动态展示学员列表
 * @USER: 11240
 * @DATE: 2022/10/8 20:24
 */
@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //连接数据,查询学员信息,拼接HTML代码,响应HTML代码到浏览器(不连接数据库了)
        response.setContentType("text/html;charset=UtF-8");
        PrintWriter out = response.getWriter();

        /*//连接数据库,拼接HTML代码
        StringBuilder html = new StringBuilder();

        html.append("<tr>");
        html.append("    <td>1</td>");
        html.append("    <td>张三</td>");
        html.append("    <td>20</td>");
        html.append("    <td>北京大兴</td>");
        html.append("</tr>");
        html.append("<tr>");
        html.append("    <td>2</td>");
        html.append("    <td>李四</td>");
        html.append("    <td>22</td>");
        html.append("    <td>北京海淀</td>");
        html.append("</tr>");

        out.print(html);*/

        //将以上程序拼接HTML,换成拼接JSON格式的字符串
        //String jsonStr = "[{\"name\":\"王五\",\"age\":20,\"addr\":\"北京大兴区\"}, {\"name\":\"李四\",\"age\":22,\"addr\":\"北京海淀区\"}]";

        //准备StringBuilder对象
        StringBuilder json = new StringBuilder();
        String jsonStr = "";

        //连接数据库,查询所有学生,拼接json字符串
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC","root","333");
            String sql = "select name,age,addr from t_student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            /*json.append("[");
            while(rs.next()){
                //获取每个学生信息
                String name = rs.getString("name");
                String age = rs.getString("age");
                String addr = rs.getString("addr");
                //拼接json格式的字符串
                //{"name":"    王五    ","age":    20    ,"addr":"    北京大兴区    "},
                json.append("{\"name\":\"");
                json.append(name);
                json.append("\",\"age\":");
                json.append(age);
                json.append(",\"addr\":\"");
                json.append(addr);
                json.append("\"},");
            }
            jsonStr = json.substring(0,json.length()-1) + "]";*/

            List<Student> studentList = new ArrayList<>();
            while (rs.next()){
                //取出数据
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String addr = rs.getString("addr");
                //将以上数据封装成Student对象
                Student s = new Student(name,age,addr);
                //将Student对象放在List集合
                studentList.add(s);
            }
            //将List集合转换成json字符串
            jsonStr = JSON.toJSONString(studentList);
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

        //响应json格式的字符串给前端
        out.print(jsonStr);
    }
}
