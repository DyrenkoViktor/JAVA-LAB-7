<%@ page import="Models.Company" %>
<%@ page import="DatabaseConnection.CompanyManager" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 19.11.2021
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add worker</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>

<h1 align="center">Adding new worker</h1>
<br/><br/><br/>

<h1 align="center" style="color: red">${incorrect_data}</h1>
    <form action="./ManagerAddWorker.jsp" method="post">
        <table align="center" style="background-color: #9fcdff">
            <tr>
                <td><h4>Worker surname</h4></td>
                <td><input type="text" name="surnameWorker" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Worker name</h4></td>
                <td><input type="text" name="nameWorker" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Worker lastname</h4></td>
                <td><input type="text" name="lastnameWorker" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Worker age</h4></td>
                <td><input type="number" name="ageWorker" min="18" max="60" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Worker salary</h4></td>
                <td><input type="number" name="salaryWorker" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Worker experience</h4></td>
                <td><input type="number" name="experienceWorker" style=" border-radius: 4px; font-size: 22px"></td>
            </tr>
            <tr>
                <td><h4>Name Company</h4></td>
                <td>
                    <select name="companyid" style=" border-radius: 4px; font-size: 22px">
                    <option disabled="Choose name company">Choose name company</option>
            <c:forEach items="${companiesId}" var="companyid">
                <option value="${companyid}" style=" border-radius: 4px">${companyid}</option>
            </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add worker" class="btn btn-success"></td>
            </tr>
        </table>
    </form>
</body>
</html>
