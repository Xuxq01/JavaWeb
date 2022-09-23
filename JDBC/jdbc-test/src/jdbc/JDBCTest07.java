package jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
    1.解决SQL注入问题
        只要用户提供的信息不参与SQL语句的编译过程就解决了
        即使含有SQL语句关键字,但不参与编译,不起作用
        要想用户信息不参与SQL语句的编译,必须使用java.sql.PreparedStatement
        PreparedStatement接口继承了java.sql.Statement
        PreparedStatement是属于预编译的数据库操作对象
        PreparedStatement的原理是预先对SQL语句的框架进行编译,然后再给SQL语句传'值'
 */
public class JDBCTest07 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登陆成功" : "登陆失败");
    }

    /*
    用户登录
    userLogInfo 用户登录信息
    return false 表示失败,true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记
        boolean loginSuccess = false;
        //JDBC代码
        Connection conn = null;
        PreparedStatement ps = null;//这里使用PreparedStatement(预编译的数据库操作对象)
        ResultSet rs = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","QIan20030625");
            //3.获取预编译的数据库操作对象
            // SQL语句的框架,其中一个?表示一个占位符,一个?接收一个值,注意,占位符不能使用单引号括起来
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            //程序执行到此处,会发送sql语句框子给DBMS,然后DBMS进行sql语句的预先编译
            ps = conn.prepareStatement(sql);
            //给占位符'?'传值(第一个问号下标是1,第二个问号下标是2,JDBC中所有下标从1开始)
            ps.setString(1,userLoginInfo.get("loginName"));
            ps.setString(2,userLoginInfo.get("loginPwd"));
            //4.执行sql
            rs = ps.executeQuery();
            //5.处理查询结果集
            if(rs.next()){
                loginSuccess = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
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
        }
        return loginSuccess;
    }

    /*
    初始化界面
    @return用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);

        System.out.println("请输入用户名:");
        String loginName = s.nextLine();

        System.out.println("请输入密码:");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        return userLoginInfo;
    }
}
