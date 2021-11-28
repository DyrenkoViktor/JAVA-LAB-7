<%@ page import="Models.Worker" %>
<%@ page import="DatabaseConnection.WorkerManager" %>
<%@ page import="java.util.Collection" %>
<%@ page import="Models.Company" %>
<%@ page import="DatabaseConnection.CompanyManager" %><%--
  Created by IntelliJ IDEA.
  User: Віктор
  Date: 22.11.2021
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Add Worker</title>
</head>
<body>

    <%

        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");

        String surname = request.getParameter("surnameWorker");
        String name = request.getParameter("nameWorker");
        String lastname = request.getParameter("lastnameWorker");
        String nameCompany = request.getParameter("companyid");
        int idCompany = companyManager.getIdByName(nameCompany);
        int age = 0;
        float salary = 0f;
        int experience = 0;


        if(!request.getParameter("ageWorker").isEmpty()){
        age = Integer.parseInt(request.getParameter("ageWorker"));}


        if(!request.getParameter("salaryWorker").isEmpty()){
        salary = Float.parseFloat(request.getParameter("salaryWorker"));}


        if(!request.getParameter("experienceWorker").isEmpty()){
        experience = Integer.parseInt(request.getParameter("experienceWorker"));}



        if(surname.isEmpty() || name.isEmpty() || lastname.isEmpty() || age == 0 || salary==0 || experience == 0){
            request.setAttribute("incorrect_data","Fields cannot be empty");
            RequestDispatcher rd = request.getRequestDispatcher("/AddWorker");
            rd.forward(request,response);

        }

else {
            Worker worker = new Worker(surname, name, lastname, age, salary, experience, idCompany);
            WorkerManager workerManager = new WorkerManager("jdbc:mysql://localhost:3306/webApp", "root", "Dyrenko Viktor");
            workerManager.addWorkerToTable(worker);
            response.sendRedirect("/lab7_1_war_exploded/AllWorkers");
}

    %>

</body>
</html>
