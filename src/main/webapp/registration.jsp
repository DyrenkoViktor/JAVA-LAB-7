<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 18.11.2021
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body style="background-color: #9fcdff">
<center><h1>Registration</h1></center>
<br><br><br><br>
<form action="${pageContext.request.contextPath}/registrationServlet" method="post">
    <center><h3 style="color: red; font-size: 28px">${incorrect_data}</h3></center>
    <center><h3 style="color: green; font-size: 28px">${success_create}</h3> </center>

    <table align="center" style="background-color: #17a2b8; border-radius: 4px" >
        <tr><td><h4>Surname</h4></td><td><input type="text" name="surname" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><h4>Name</h4></td><td><input type="text" name="name" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><h4>Email</h4></td><td><input type="text" name="email" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><h4>Nickname</h4></td><td><input type="text" name="nickname" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><h4>Password</h4></td><td><input type="password" name="password1" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><h4>Retype password</h4></td><td><input type="password" name="password2" style=" border-radius: 2px; font-size: 22px"></td></tr>
        <tr><td><input type="submit" value="Sign up" name="registrate" class = "btn btn-success"></td></tr>
        <tr><td><button class = "btn btn-primary"><a style="text-decoration: none; color: white" href="login.jsp">Log in</a></button></td></tr>
    </table>
</form>
</body>
</html>
