<%@page contentType="text/html;charset=UTF-8" isELIgnored="true" %>
<%--忽略EL表达式--%>

<%
    request.setAttribute("username","zhangsan");
%>

<%--isELIgnored="true"表示忽略JSP中整个页面的所有EL表达式,如果想忽略其中某个,可以使用反斜杠--%>
\${username}
${username}
${username}