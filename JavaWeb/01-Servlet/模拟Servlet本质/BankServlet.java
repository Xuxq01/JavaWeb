package com.bjpowernode.servlet;

import javax.servlet.Servlet;
//�䵱�Ľ�ɫwebapp������
//ֻҪ������webapp������д��XXXServlet��Ҫʵ��Servlet�ӿ�
public class BankServlet implements Servlet{
	public void service(){
		System.out.println("BankServlet's Service...");
	}
}