package com.bjpowernode.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet implements Servlet{

	// 5������
	public void init(ServletConfig config) throws ServletException{
	
	}

	public void service(ServletRequest request,ServletResponse response)
		throws ServletException , IOException{

		// �����̨��ӡ���
		System.out.println("My First Servlet, Hello Servlet");

		//������Ӧ��������������ͨ�ı���html����
		response.setContentType("text/html");

		//��ô��һ����Ϣֱ��������������?
		//��Ҫʹ��ServletResponse�ӿ�:response
		//response��ʾ��Ӧ:�ӷ�������������������ݽ���Ӧ
		PrintWriter out = response.getWriter();

		out.print("Hello Servlet,You are my first Servlet");

		//��������ܹ�ʶ��html�����,�������ǲ���Ӧ�����һ��HTML������?
		out.print("<h1>hello servlet</h1>");

		//����һ�������,��������ַ����������
		//����Ҫ����ˢ�¹ر�,����Tomcat��ά��
		/*
			out.flush();
			out.close();
		*/
	}

	public void destroy(){
	
	}

	public String getServletInfo(){
		return "";
	}

	public ServletConfig getServletConfig(){
		return null;
	}
}