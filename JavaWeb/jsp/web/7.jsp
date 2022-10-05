<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page import="com.bjpowernode.javaweb.jsp.bean.Address" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    User user = new User();
    user.setUsername("jackon");
    user.setPassword("1234");
    user.setAge(50);

    Address a = new Address();
    a.setCity("北京");
    a.setStreet("大兴区");
    a.setZipcode("111111");

    user.setAddr(a);

    request.setAttribute("userObj",user);
%>

<%--使用EL表达式,从request域当中,去除User对象,并将其输出到浏览器--%>
${userObj}

<hr>

${userObj.username}

<br>

${userObj.password}
<br>
${userObj.age}
<br>
${userObj.email}
<br>
城市:${userObj.addr.city}<br>
街道:${userObj.addr.street}<br>
邮编:${userObj.addr.zipcode}<br>