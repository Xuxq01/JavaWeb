/*
	ע����������һ�ַ�ʽ(���ַ�ʽ����)
*/
import java.sql.*;
public class JDBCTest03{
	public static void main(String[] args){
		try{
			//1.ע������
			//����ע�������ĵ�һ��д��
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//ע�������ĵڶ��ַ�ʽ(����)
			//��Ϊ������һ���ַ���,�ַ�������д��xxx.properties�ļ�����
			//���·�������Ҫ���շ���ֵ,��Ϊ����ֻ������������ض���
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","QIan20030625");
			System.out.println(conn);

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}