<%@ page import="com.bjpowernode.oa.servlet.web.action.DeptServlet" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List, com.bjpowernode.oa.servlet.bean.Dept"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表页面</title>
	</head>
	<body>

	<%--显示一个登录名--%>
	<h3>欢迎[<%=session.getAttribute("username")%>]</h3>
	<a href="<%=request.getContextPath()%>/user/exit">退出系统</a>

<script type="text/javascript">
	function del(dno){
		var ok = window.confirm("删了不可恢复！");
		if(ok){
			document.location.href = "<%=request.getContextPath()%>/dept/delete?deptno=" + dno;
		}
	}
</script>

		<h1 align="center">部门列表</h1>
		<hr >
		<table border="1px" align="center" width="50%">
			<tr>
				<th>序号</th>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
			<%
				List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
				//循环遍历
				int i = 0;
				for(Dept dept:deptList){
					//在后台输出
					//System.out.println(dept.getDname());
			%>
			<tr>
				<td><%=++i%></td>
				<td><%=dept.getDeptno()%></td>
				<td><%=dept.getDname()%></td>
				<td>
					<a href="javascript:void(0)" onclick="del(<%=dept.getDeptno()%>)">删除</a>
					<a href="<%=request.getContextPath()%>/dept/detail?f=edit&dno=<%=dept.getDeptno()%>">修改</a>
					<a href="<%=request.getContextPath()%>/dept/detail?f=detail&dno=<%=dept.getDeptno()%>">详情</a>
				</td>
			</tr>
			<%
				}
			%>

		</table>
		
		<hr >
		<a href="<%=request.getContextPath()%>/old/add.jsp">新增部门</a>
		
	</body>
</html>
