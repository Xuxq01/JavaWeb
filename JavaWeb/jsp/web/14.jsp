<%@ page contentType="text/html;charset=UTF-8" %>

<%--从以下代码来看,pageContext.getRequest()方法没用,这里获取request对象,而JSP中内置了对象request,直接用request就行了--%>
<%=pageContext.getRequest()%>
<br>
<%=request%>
<hr>
<%--在EL表达式中没有request这个隐式对象,requestScope只代表请求范围,不等同于request对象,EL表达式中有一个隐式对象,pageContext,与九大内置对象中的是同一个--%>
<%--<%=pageContext.getRequest()%>--%>
<%=((jakarta.servlet.http.HttpServletRequest)pageContext.getRequest()).getContextPath() %>
<%--使用EL表达式获取应用的根路径--%>
${pageContext.request.contextPath}
