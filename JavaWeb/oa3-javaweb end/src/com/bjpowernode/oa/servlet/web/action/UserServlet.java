package com.bjpowernode.oa.servlet.web.action;

import com.bjpowernode.oa.servlet.bean.User;
import com.bjpowernode.oa.servlet.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Servlet负责业务的处理
//JSP负责页面的展示
@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/login".equals(servletPath)){
            doLogin(request,response);
        }else if ("/user/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    protected void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取session对象,销毁session
        HttpSession session = request.getSession(false);
        if(session != null){
            //从session域中删除User对象
            session.removeAttribute("user");
            //手动销毁session对象
            session.invalidate();
            //销毁cookie(退出系统,将所有的cookie全部销毁)
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());//删除cookie的时候注意路径问题
                    //响应cookie给浏览器,浏览器会将之前的cookie覆盖
                    response.addCookie(cookie);
                }
            }

            //换一种方案
            /*Cookie cookie1 = new Cookie("username","");
            Cookie cookie2 = new Cookie("password","");
            cookie1.setMaxAge(0);
            cookie2.setMaxAge(0);
            cookie1.setPath(request.getContextPath());
            cookie2.setPath(request.getContextPath());

            response.addCookie(cookie1);
            response.addCookie(cookie2);*/

            //跳转到登陆页面
            response.sendRedirect(request.getContextPath());
        }
    }

    //cookie:名字叫做username,但是这个cookie关联的路径是/oa
    //cookie:名字也叫作username,但是这个cookie关联的路径是/oa/user

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean success = false;
        //验证用户名和密码是否正确
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //连接数据库验证用户名和密码
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //这个结果集只能有一条或者没有数据
            if (rs.next()) {
                //成功
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        //登录成功/失败
        if(success){
            HttpSession session = request.getSession();//session对象一定不是null
            //session.setAttribute("username",username);

            User user = new User(username,password);
            session.setAttribute("user",user);

            //登陆成功了,并且用户选择了十天内免登录
            if("1".equals(request.getParameter("f"))){
                //创建Cookie对象存储登录名
                Cookie cookie1 = new Cookie("username", username);
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                //创建Cookie对象存储密码
                Cookie cookie2 = new Cookie("password", password);//真实情况下是加密的
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                //设置cookie的path(只要访问这个应用,就一定要携带这两个cookie)
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                //响应cookie的浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }

            //跳转到用户列表页面
            response.sendRedirect(request.getContextPath() + "/dept/list");
        }else{
            //跳转到失败页面
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
