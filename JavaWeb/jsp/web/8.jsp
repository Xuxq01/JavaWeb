<%@page contentType="text/html;charset=UTF-8" %>

<%
    /*四个域都存储了数据,并且name相同*/
    pageContext.setAttribute("data","pageContext");
    request.setAttribute("data","request");
    session.setAttribute("data","session");
    application.setAttribute("data","application");
%>
<%--EL表达式优先从小范围中取出数据(在没有指定范围的前提下)--%>
${data}
<br>
<%--在EL表达式可以指定范围来读取数据--%>
<%--EL表达式有四个隐含的范围对象--%>
<%--pageScope requestScope sessionScope applicationScope--%>
${pageScope.data}<br>
${requestScope.data}<br>
${sessionScope.data}<br>
${applicationScope.data}<br>