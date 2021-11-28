<%@ page import="DatabaseConnection.CityManager" %>
<%@ page import="Models.Company" %>
<%@ page import="DatabaseConnection.CompanyManager" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 25.11.2021
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager add company</title>
</head>
<body>
<%

    CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");

    String name = request.getParameter("nameCompany");
    String phone = request.getParameter("phoneCompany");
    int codeCity=0;
    String nameCity = request.getParameter("cityid");
    codeCity = cityManager.getIdCityByName(nameCity);


    if(name.isEmpty() || phone.isEmpty()){
        request.setAttribute("incorrect_data","Fields cannot be empty");
        RequestDispatcher rd = request.getRequestDispatcher("/AddCompany");
        rd.forward(request,response);

    }

    else {
        Company company = new Company(name, phone, codeCity);
        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");
        companyManager.addCompany(company);
        response.sendRedirect("/lab7_1_war_exploded//AllCompanies");
    }

%>
</body>
</html>
