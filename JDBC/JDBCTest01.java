/*
	JDBC编程六步
*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class JDBCTest01{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1.注册驱动
			Driver driver = new com.mysql.jdbc.Driver();//多态,父类型引用指向子类型对象
			DriverManager.registerDriver(driver);

			//2.获取连接
			/*
				url:统一资源定位符(网络中某个资源的绝对路径)
				URL包括
					协议
					IP
					PORT
					资源名

				http://14.215.177.39:80/index.html
					http:// 通信协议
					14.215.177.39 服务器IP地址
					80 服务器上软件的端口
					index.html 服务器上的某个资源名

				jdbc:mysql://127.0.0.1:3306/bjpowernode
					jdbc:mysql: 协议
					127.0.0.1 IP 地址
					3306 mysql数据库端口
					bjpowernode 具体的数据库实例名

				说明:localhost和127.0.0.1都是本机ip地址

				什么是通信协议?有什么用?
					通信协议是通信之前就提前定好的数据传送格式
					数据包具体怎么传数据,格式提前定好的
			*/
			String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
			String user = "root";
			String password = "123";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接对象 = " + conn);

			//3.获取数据库操作对象(Statement专门执行sql语句的)
			stmt = conn.createStatement();

			//4.执行sql
			String sql = "insert into dept (deptno,dname,loc) values(50,'RENSHIBU','BEIJING')";
			//专门执行DML语句(insert delete update)
			//返回值是"影响数据库中的记录条数"
			int count = stmt.executeUpdate(sql);
			System.out.println(count == 1 ? "保存成功" : "保存失败");
			
			//5.处理查询结果集
			
		}
		catch (Exception e){
			e.printStackTrace();
		}finally {
			//6.释放资源
			//为了保证资源一定释放,在finally语句块中关闭资源
			//并且要遵循从小到大依次关闭
			//分别对其try...catch
			try{
				if(stmt != null){
					stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(conn != null){
				conn.close();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}