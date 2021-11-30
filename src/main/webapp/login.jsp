<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 16.11.2021
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">

    <title>Login</title>
</head>
<body style="background-color: #9fcdff">
<br><br><br><br>
<center><h1>Login Page</h1></center>
<center><h3 style="color: red; font-size: 28px">${message}</h3></center>
<br><br><br><br>

    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <table align="center" style="background-color: #17a2b8">
            <div class="login">
            <tr>
                <th align="right"> User nickname </th>
                <td><input type="text" name="nickname"></td></tr>
            <tr>
                <th align="right"> Password   </th>
                <td><input type="password" name="password"></td></tr>
            </div>
                <tr>
                <td colspan="2" align="right"><input style="width:105px" type="submit" value="Log in" name="login" class="btn btn-primary"></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><button class = "btn bth-success"><a style="text-decoration: none" href="registration.jsp">Registration</a></button></td>
            </tr>
        </table>
    </form>

</body>
</html>
