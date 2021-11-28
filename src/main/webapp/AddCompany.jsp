<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 24.11.2021
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add company</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<h1 align="center">Adding new company</h1>
<br/><br/><br/>

<h1 align="center" style="color: red">${incorrect_data}</h1>
<form action="./ManagerAddCompany.jsp" method="post">
    <table align="center" style="background-color: #9fcdff">
        <tr>
            <td><h4>Name company</h4></td>
            <td><input type="text" name="nameCompany" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Phone company</h4></td>
            <td><input type="text" name="phoneCompany" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Name City</h4></td>
            <td>
                <select name="cityid" style=" border-radius: 4px; font-size: 22px">
                    <option disabled>Choose name city</option>
                    <c:forEach items="${citiesId}" var="citiid">
                        <option value="${citiid}">${citiid}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add company" class="btn btn-success"></td>
        </tr>
    </table>
</form>

</body>
</html>
