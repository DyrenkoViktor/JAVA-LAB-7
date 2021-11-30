<%@ page import="DatabaseConnection.UserManager" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 26.11.2021
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String role = request.getParameter("whichRole");
    int id = Integer.parseInt(request.getParameter("currentId"));

    UserManager userManager = new UserManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");
    userManager.updateRole(role,id);

    response.sendRedirect("/lab7_1_war_exploded/AllUsers");
%>
</body>
</html>
