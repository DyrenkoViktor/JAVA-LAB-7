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

@WebServlet(name = "FilterByAge", value = "/FilterByAge")
public class FilterByAge extends HttpServlet {

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

        String age = request.getParameter("filterByAge");
        Collection<Worker> workers = new ArrayList<Worker>();

        if(age.equals("<25")){
            try {
                workers = workerManager.filterByAge(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(age.equals("25-40")){
            try {
                workers = workerManager.filterByAge(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(age.equals("40-55")){
            try {
                workers = workerManager.filterByAge(2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        else if(age.equals("55-60")){
            try {
                workers = workerManager.filterByAge(3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(workers.isEmpty()){
            request.setAttribute("range", "Workers with age "+age);
            request.setAttribute("NotFound","Not found workers with age "+age);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("range","Workers with age "+age);
            request.setAttribute("workers", workers);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
    }
}
