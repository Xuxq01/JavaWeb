<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String name = "jack";
    //输出name到控制台
    System.out.println("name = " + name);

    //可以直接在这个符号中使用
    out.write("name = " + name);
    out.write("zhangsan");
    out.write("lisi");
    out.write("wangwu");
%>

<br>
zhangsan
lisi
wangwu

<%= 100 + 200%>

<%
    int a = 100;
    int b = 200;
    int c = a + b;
%>

<%=c%>      <%-----out.print(c);--%>