模拟Servlet本质
充当SUN公司角色,制定Servlet规范
	javax.servlet.Servlet接口
充当Tomcat服务器的开发者
充当Webapp的开发者
	BankServlet implements Servlet
	UserListServlet implements Servlet
	UserLoginServlet implements Servlet
通过我们的分析:
	对于我们javaweb程序员来说,我们只需要做两件事:
		编写一个类实现Servlet接口
		将编写的类配置到配置文件中,并在配置文件中:指定  请求路径  和  类名  的关系
注意:
	这个配置文件的文件名不能乱来,固定的
	这个配置文件的存放路径不能乱来,固定的
	文件名,文件路径都是SUN公司制定的Servlet规范中的明细
严格意义上Servlet其实并不是一个简单的接口
Tomcat服务器要遵循Servlet规范,javaweb程序员也要遵循Servlet规范,这样Tomcat服务器和webapp才能解耦合