/*
	�����ѯ�����
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
			rs = stmt.executeQuery(sql);//ר��ִ��DQL���ķ���
			/*//5.�����ѯ�����
			boolean flag1 = rs.next();
			//System.out.println(flag1);//true
			if(flag1){
				//���ָ�����������
				//ȡ����
				//getString()�������ص�:�������ݿ��е�������ʲô,����String����ʽȡ��
				String empno = rs.getString(1);//JDBC�������±��1��ʼ,����0
				String ename = rs.getString(2);
				String sal = rs.getString(3);
				System.out.println(empno + "," + ename + "," + sal);
			}
			*/

			while(rs.next()){
				//����������е��±��ȡ,���е����ֻ�ȡ
				//���˿�����String����ȡ��֮��,���������ض�������ȡ��
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