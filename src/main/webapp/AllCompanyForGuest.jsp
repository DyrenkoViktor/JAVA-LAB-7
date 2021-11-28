<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 28.11.2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All companies</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
<jsp:include page="navForGuest.jsp"></jsp:include>
<h1>List of all companies</h1>
<h4>Filter workers</h4>
<form action="./FilterByCity" method="post">
    <tr>
        <td>
            <select name="filterByCity">
                <option disabled="Choose name city">Choose name city</option>
                <c:forEach items="${listcity}" var="listcity">
                    <option value="${listcity}">${listcity}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="submit" value="Search by city" class="btn btn-info">
        </td>
    </tr>
</form>
<br/>
<table class="table">
    <tr>
        <td scope="col"><h5>Name company</h5></td>
        <td scope="col"><h5>Phone company</h5></td>
        <td scope="col"><h5>Name city</h5></td>
    </tr>

    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.getName()}</td>
            <td>${company.getPhoneCompany()}</td>
            <td>${company.getNameCity()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
