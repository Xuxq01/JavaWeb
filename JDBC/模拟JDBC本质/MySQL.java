//MySQL的数据库厂家负责编写JDBC接口的实现类
public class MySQL implements JDBC
{
	public void getConnection()
	{
		//具体这里的代码怎么写对于java程序员来说没关系
		//涉及到MySQL数据库底层的实现原理
		System.out.println("连接MySQL数据库成功");
	}
}
//实现类被称为驱动,MySQL驱动