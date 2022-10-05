<%@page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("username","zhangsan");
%>

<%--取出数据输出到浏览器--%>
<%=request.getAttribute("username")%>
采用EL表达式:${username}
<br>
<%=request.getAttribute("username")%>
采用EL表达式:${usernam} 这个EL表达式等同于这一段java代码: <%=request.getAttribute("usernam" == null ? "" : request.getAttribute("usernam"))%>