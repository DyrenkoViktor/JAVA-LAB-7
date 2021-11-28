<%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 22.11.2021
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editing Worker</title>
    <link rel="stylesheet" href = "CSS/bootstrap.css" type="text/css">
</head>
<body>
    <h2 align="center">Change information about worker</h2>
        <form action="./ManageEditWorker.jsp" method="post">
            <br/><br/><br/>
            <table align="center" style="background-color: #9fcdff">
                <tr>
                    <td><h4>Current Surname</h4></td>
                    <td><input type = "text" name="surnameWorker" value="${workerSurname}" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current name</h4></td>
                    <td><input type="text" name="nameWorker" value="${workerName}" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current lastname</h4></td>
                    <td><input type="text" name="lastnameWorker" value="${workerLastname}" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current age</h4></td>
                    <td> <input type="number" name="ageWorker" value="${workerAge}" min="18" max="60" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current salary</h4></td>
                    <td><input type="number" name="salaryWorker" value="${workerSalary}" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current experience</h4></td>
                    <td><input type="number" name="experienceWorker" value="${workerExperience}" min="1" style=" border-radius: 4px; font-size: 22px"></td>
                </tr>
                <tr>
                    <td><h4>Current name company</h4></td>
                    <td><h4>${workerCodeCompany}</h4></td>
                </tr>
                <tr>
                    <td><h4>Choose name company if you want</h4></td>
                    <td>  <select name="codeCompany" style=" border-radius: 4px; font-size: 22px">
                        <option disabled>Choose code company</option>
                        <option value="${workerCodeCompany}">${workerCodeCompany}</option>
                        <c:forEach items="${codesCompany}" var="codesCompany">
                            <option value="${codesCompany}">${codesCompany}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save changes" class="btn btn-success"></td>
                </tr>
            <input type ="hidden" name="idWorker" value="${workerId}">

            </table>
        </form>

</body>
</html>
