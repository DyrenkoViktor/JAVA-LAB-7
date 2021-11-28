<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 26.11.2021
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All cities</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForAdmin.jsp"></jsp:include>
<h1>List of all available cities</h1>

<table class="table">
    <tr>
        <td scope="col"><h5>ID city</h5></td>
        <td scope="col"><h5>Name city</h5></td>
    </tr>

    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.getId()}</td>
            <td>${city.getName()}</td>
            <td>
                <form action="./deletecity?id=${city.getId()}" method="post">
                    <input type="hidden" name="deleteIdCity" value="${city.getId()}">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </td>
        </tr>
    </c:forEach>
    <button><a href="./AddCity.jsp" style="text-decoration: none">Add city</a> </button>
</table>
</body>
</html>
