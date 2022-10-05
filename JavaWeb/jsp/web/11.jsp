<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    Map<String,String> map = new HashMap();
    map.put("username","zhangsan");
    map.put("password","123");

    /*将Map集合存储到request域当中*/
    request.setAttribute("userMap",map);

    Map<String,User> map2 = new HashMap<>();
    User user = new User();
    user.setUsername("lisi");
    map2.put("user",user);
    request.setAttribute("fadsadw",map2);
%>
<%--使用EL表达式,将Map集合中的user对象中的username输出--%>
${fadsadw.user.username}<br>
<hr>

<%--使用EL表达式,将map中的数据取出,并输出到浏览器上--%>
${userMap.username}<br>
${userMap.password}<br>
${userMap["username"]}<br>
${userMap["password"]}<br>