<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 26.11.2021
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit role user</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body style="background-color: #49aaf5">
<h1 align="center">Change role for ${nickname}</h1>
<br/><br/><br/>

<table align="center" class="table">
    <tr>
        <td><h4>ID user</h4></td>
        <td><h4>${idUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Surname user</h4></td>
        <td><h4>${surnameUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Name user</h4></td>
        <td><h4>${nameUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Email user</h4></td>
        <td><h4>${emailUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Nickname user</h4></td>
        <td><h4>${nicknameUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Password user</h4></td>
        <td><h4>${passwordUser}</h4></td>
    </tr>
    <tr>
        <td><h4>Current role user</h4></td>
        <td><h4>${roleUser}</h4></td>
    </tr>

    <tr>
        <td>
        <form action="./ManagerEditRoleUser.jsp" method="post">
            <input type="hidden" name="currentId" value="${idUser}">
            <select name="whichRole" style=" border-radius: 4px; font-size: 22px">
                <option value="admin">admin</option>
                <option value="guest">guest</option>
            </select>

            <input type="submit" value="Change role" class="btn btn-success">
        </form>
        </td>
    </tr>
</table>
</body>
</html>
