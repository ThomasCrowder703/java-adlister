<%--
  Created by IntelliJ IDEA.
  User: thomascrowder
  Date: 11/3/20
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("password")){
            response.sendRedirect("/profile.jsp");  //redirect
        }
    }

%>
<html>
<%@ include file="partials/head.jsp"%>
<body>

<form action="/login.jsp" method="post"> <%--line 10--%>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">  <%-- line 11--%>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password">  <%-- line 12--%>
    <input type="submit">
</form>



</body>
</html>
