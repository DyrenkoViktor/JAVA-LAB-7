<%@ page import="Models.Company" %>
<%@ page import="DatabaseConnection.CompanyManager" %>
<%@ page import="DatabaseConnection.CityManager" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 25.11.2021
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager edit company</title>
</head>
<body>
<%

    int id = Integer.parseInt(request.getParameter("idCompany"));
    String name = request.getParameter("nameCompany");
    String phone = request.getParameter("phoneCompany");
    String nameCity = request.getParameter("codeCity");
    CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");

    int idCity = cityManager.getIdCityByName(nameCity);



        Company company = new Company(id, name, phone, idCity,nameCity);

        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");
        companyManager.editCompany(company);
        response.sendRedirect("/lab7_1_war_exploded/AllCompanies");

%>


</body>
</html>
