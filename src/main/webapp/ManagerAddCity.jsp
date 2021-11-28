<%@ page import="DatabaseConnection.CityManager" %>
<%@ page import="Models.City" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 26.11.2021
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Add city</title>
</head>
<body>
<%

    String nameCity = request.getParameter("nameCity");

    CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");


    if(!nameCity.isEmpty()){
    City city = new City(nameCity);

    cityManager.addCity(city);
        response.sendRedirect("/lab7_1_war_exploded//AllCities");}
    else {

        request.setAttribute("incorrect_data","Field cannot be empty");
        RequestDispatcher rd = request.getRequestDispatcher("AddCity.jsp");
        rd.forward(request,response);
    }
%>
</body>
</html>
