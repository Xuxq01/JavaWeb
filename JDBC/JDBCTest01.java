/*
	JDBC�������
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
			//1.ע������
			Driver driver = new com.mysql.jdbc.Driver();//��̬,����������ָ�������Ͷ���
			DriverManager.registerDriver(driver);

			//2.��ȡ����
			/*
				url:ͳһ��Դ��λ��(������ĳ����Դ�ľ���·��)
				URL����
					Э��
					IP
					PORT
					��Դ��

				http://14.215.177.39:80/index.html
					http:// ͨ��Э��
					14.215.177.39 ������IP��ַ
					80 ������������Ķ˿�
					index.html �������ϵ�ĳ����Դ��

				jdbc:mysql://127.0.0.1:3306/bjpowernode
					jdbc:mysql: Э��
					127.0.0.1 IP ��ַ
					3306 mysql���ݿ�˿�
					bjpowernode ��������ݿ�ʵ����

				˵��:localhost��127.0.0.1���Ǳ���ip��ַ

				ʲô��ͨ��Э��?��ʲô��?
					ͨ��Э����ͨ��֮ǰ����ǰ���õ����ݴ��͸�ʽ
					���ݰ�������ô������,��ʽ��ǰ���õ�
			*/
			String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
			String user = "root";
			String password = "123";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("���ݿ����Ӷ��� = " + conn);

			//3.��ȡ���ݿ��������(Statementר��ִ��sql����)
			stmt = conn.createStatement();

			//4.ִ��sql
			String sql = "insert into dept (deptno,dname,loc) values(50,'RENSHIBU','BEIJING')";
			//ר��ִ��DML���(insert delete update)
			//����ֵ��"Ӱ�����ݿ��еļ�¼����"
			int count = stmt.executeUpdate(sql);
			System.out.println(count == 1 ? "����ɹ�" : "����ʧ��");
			
			//5.�����ѯ�����
			
		}
		catch (Exception e){
			e.printStackTrace();
		}finally {
			//6.�ͷ���Դ
			//Ϊ�˱�֤��Դһ���ͷ�,��finally�����йر���Դ
			//����Ҫ��ѭ��С�������ιر�
			//�ֱ����try...catch
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