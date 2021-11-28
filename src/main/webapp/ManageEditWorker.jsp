<%@ page import="Models.Worker" %>
<%@ page import="DatabaseConnection.WorkerManager" %>
<%@ page import="DatabaseConnection.CompanyManager" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 22.11.2021
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage edit worker</title>
</head>
<body>
<%

    int idWorker = Integer.parseInt(request.getParameter("idWorker"));
    String surname = request.getParameter("surnameWorker");
    String name = request.getParameter("nameWorker");
    String lastname = request.getParameter("lastnameWorker");
    int age = Integer.parseInt(request.getParameter("ageWorker"));
    float salary = Float.parseFloat(request.getParameter("salaryWorker"));
    int experience = Integer.parseInt(request.getParameter("experienceWorker"));
    String nameCompany = request.getParameter("codeCompany");




    CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");

    int idCompany = companyManager.getIdByName(nameCompany);

    Worker worker = new Worker(idWorker,surname,name,lastname,age,salary,experience,nameCompany,idCompany);


    WorkerManager workerManager = new WorkerManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");
    workerManager.editWorker(worker);


    response.sendRedirect("/lab7_1_war_exploded/AllWorkers");

%>
</body>
</html>
