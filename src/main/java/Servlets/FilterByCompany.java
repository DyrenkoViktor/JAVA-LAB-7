package Servlets;

import DatabaseConnection.WorkerManager;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "FilterByCompany", value = "/FilterByCompany")
public class FilterByCompany extends HttpServlet {
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
        String name = request.getParameter("filterByComapny");
        Collection<Worker> workers = null;

        try {
            workers = workerManager.filterByCompany(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(workers.isEmpty()){
            request.setAttribute("company","Workers which work at company "+name);
            request.setAttribute("NotFound","Not found workers who work at company "+name);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("company","Workers which work at company "+name);
            request.setAttribute("workers", workers);
            RequestDispatcher rd = request.getRequestDispatcher("WorkerFilter.jsp");
            rd.forward(request, response);

        }
    }
}
