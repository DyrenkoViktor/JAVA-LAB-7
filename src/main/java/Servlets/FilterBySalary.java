package Servlets;

import DatabaseConnection.WorkerManager;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "FilterBySalary", value = "/FilterBySalary")
public class FilterBySalary extends HttpServlet {
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
        String salary = request.getParameter("filterBySalary");
        Collection<Worker> workers = new ArrayList<Worker>();

        if(salary.equals("<1500")){
            try {
                workers = workerManager.filterBySalary(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(salary.equals("1500-3000")){
            try {
                workers = workerManager.filterBySalary(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(salary.equals("3000-5000")){
            try {
                workers = workerManager.filterBySalary(2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(salary.equals(">5000")){
            try {
                workers = workerManager.filterBySalary(3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(workers.isEmpty()){
            request.setAttribute("salary","Workers with salary "+salary);
            request.setAttribute("NotFound","Not found workers with salary "+salary);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("salary","Workers with salary "+salary);
            request.setAttribute("workers", workers);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
    }
}
