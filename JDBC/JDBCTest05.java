/*
	处理查询结果集
*/
import java.sql.*;

public class JDBCTest05{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123");
			stmt = conn.createStatement();
			String sql = "select empno,ename,sal from emp";
			//int executeUpdate(insert delete update)
			//ResultSet executeQuery(select)
			rs = stmt.executeQuery(sql);//专门执行DQL语句的方法
			/*//5.处理查询结果集
			boolean flag1 = rs.next();
			//System.out.println(flag1);//true
			if(flag1){
				//光标指向的行有数据
				//取数据
				//getString()方法的特点:不管数据库中的类型是什么,都以String的形式取出
				String empno = rs.getString(1);//JDBC中所有下标从1开始,不是0
				String ename = rs.getString(2);
				String sal = rs.getString(3);
				System.out.println(empno + "," + ename + "," + sal);
			}
			*/

			while(rs.next()){
				//这个不是以列的下标获取,以列的名字获取
				//除了可以以String类型取出之外,还可以以特定的类型取出
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String sal = rs.getString("sal");
				System.out.println(empno + "," + ename + "," + sal);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
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