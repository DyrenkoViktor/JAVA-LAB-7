package Servlets;

import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;
import Models.Company;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "EditWorker", value = "/edit")
public class EditWorker extends HttpServlet {

    private WorkerManager workerManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        workerManager = new WorkerManager(url,user,pass);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker worker = null;

        int id = Integer.parseInt(request.getParameter("editId"));


        try {
            worker=workerManager.getWorkerById(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collection<String> companies = null;
        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root","Dyrenko Viktor");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("workerId",worker.getId());
        request.setAttribute("workerSurname",worker.getSurname());
        request.setAttribute("workerName",worker.getName());
        request.setAttribute("workerLastname",worker.getLastname());
        request.setAttribute("workerAge",worker.getAge());
        request.setAttribute("workerSalary",worker.getSalary());
        request.setAttribute("workerExperience",worker.getExperience());
        request.setAttribute("workerCodeCompany",worker.getNameCompany());
        request.setAttribute("codesCompany",companies);

        RequestDispatcher rd = request.getRequestDispatcher("EditWorker.jsp");
        rd.forward(request,response);
    }



}
