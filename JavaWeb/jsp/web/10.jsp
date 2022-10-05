<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    User user = new User();
    user.setUsername("zhangsan");

    request.setAttribute("faidasad",user);

    request.setAttribute("abc.def","hello jsp el");
%>

<%--使用EL表达式取出,并且输出到浏览器--%>
${faidasad}<br>
${faidasad.username}<br>
<%--取user的username,注意[]中需要添加双引号--%>
${faidasad["username"]}<br>

<%--将数据取出并输出到浏览器--%>
${requestScope.abc.def}<br><%--null--%>
${requestScope["abc.def"]}<br>
${abc.def}<br>