<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 25.11.2021
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editing company</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
<h2 align="center">Change information about company</h2>
<br/><br/><br/>
<form action="./ManagerEditCompany.jsp" method="post">
    <table align="center" style="background-color: #9fcdff">
        <tr>
            <td><h4>Current name company</h4></td>
            <td><input type = "text" name="nameCompany" value="${companyName}" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Current phone company</h4></td>
            <td><input type="text" name="phoneCompany" value="${companyPhone}" style=" border-radius: 4px; font-size: 22px"></td>
        </tr>
        <tr>
            <td><h4>Current name city</h4></td>
            <td><h4>${codecity}</h4></td>
        </tr>
        <tr>
            <td><h4>Change name city if you want</h4></td>
            <td><select name="codeCity" style=" border-radius: 4px; font-size: 22px">
                <option disabled="Choose code city">Choose code city</option>
                <option value="${codecity}">${codecity}</option>
                <c:forEach items="${codesCity}" var="codes">
                    <option value="${codes}">${codes}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save changes" class="btn btn-success"></td>
        </tr>
    <input type ="hidden" name="idCompany" value="${companyId}">
    </table>
</form>
</body>
</html>
