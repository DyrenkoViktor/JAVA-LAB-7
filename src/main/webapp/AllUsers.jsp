<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 26.11.2021
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForAdmin.jsp"></jsp:include>
<h1>List of all available users</h1>
<table class="table">
    <tr>
        <td scope="col"><h5>ID user</h5></td>
        <td scope="col"><h5>Surname user</h5></td>
        <td scope="col"><h5>Name user</h5></td>
        <td scope="col"><h5>Email user</h5></td>
        <td scope="col"><h5>Nickname user</h5></td>
        <td scope="col"><h5>Password user</h5></td>
        <td scope="col"><h5>RoleUser</h5></td>
    </tr>
    <tr>
        <td>${userId}</td>
        <td>${userSurname}</td>
        <td>${userName}</td>
        <td>${userEmail}</td>
        <td>${userNickname}</td>
        <td>${userPassword}</td>
        <td>${userRole}</td>
    </tr>

    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getSurname()}</td>
        <td>${user.getName()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getNickname()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getRole()}</td>
        <td>
            <form action="./editRole?id=${user.getId()}" method="post">
                <input type="hidden" name="editRoleUser" value="${user.getId()}">
                <input type="submit" value="Edit role" class="btn btn-warning">
            </form>
        </td>
        <td>
            <form action="./deleteUser?id=${user.getId()}" method="post">
                <input type="hidden" name="deleteIdUser" value="${user.getId()}">
                <input type="submit" value="Delete user" class="btn btn-danger">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
