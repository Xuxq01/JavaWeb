/*
	JDBC完成delete
*/
import java.sql.*;
/*
	JDBC完成delete update
*/
public class JDBCTest02{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1.注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//2.获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
			//3.获取数据库操作对象
			stmt = conn.createStatement();
			//4.执行sql语句
			//String sql = "delete from dept where deptno = 40";
			//JDBC中的语句不需要提供分号结尾
			String sql = "update dept set dname = 'XIAOSHOUBU',loc = 'TIANJIN' where deptno = 20";
			int count = stmt.executeUpdate(sql);
			System.out.println(count == 1 ? "删除成功" : "删除失败");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6.释放资源
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}