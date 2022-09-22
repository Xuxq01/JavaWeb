/*
	注册驱动的另一种方式(这种方式常用)
*/
import java.sql.*;
public class JDBCTest03{
	public static void main(String[] args){
		try{
			//1.注册驱动
			//这是注册驱动的第一种写法
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//注册驱动的第二种方式(常用)
			//因为参数是一个字符串,字符串可以写到xxx.properties文件当中
			//以下方法不需要接收返回值,因为我们只想用他的类加载动作
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","QIan20030625");
			System.out.println(conn);

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}