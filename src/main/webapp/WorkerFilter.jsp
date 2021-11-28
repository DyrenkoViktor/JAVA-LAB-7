<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 27.11.2021
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body style="background-color: #49aaf5">
<h1>${range}</h1>
<h1>${salary}</h1>
<h1>${company}</h1>
<h1 align="center" style="color: red; font-size: 28px">${NotFound}</h1>
<table class="table">
    <tr>
        <td scope="col"><h5>Surname worker</h5></td>
        <td scope="col"><h5>Name worker</h5></td>
        <td scope="col"><h5>Lastname worker</h5></td>
        <td scope="col"><h5>Age worker</h5></td>
        <td scope="col"><h5>Salary worker</h5></td>
        <td scope="col"><h5>Experience worker</h5></td>
        <td scope="col"><h5>Name company</h5></td>
    </tr>
    <c:forEach items="${workers}" var="worker">
        <tr>
            <td>${worker.getSurname()}</td>
            <td>${worker.getName()}</td>
            <td>${worker.getLastname()}</td>
            <td>${worker.getAge()}</td>
            <td>${worker.getSalary()}</td>
            <td>${worker.getExperience()}</td>
            <td>${worker.getNameCompany()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
