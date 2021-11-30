package Servlets;

import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;
import Models.Worker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;


@WebServlet(value = "/AllWorkers")
public class AllWorkerServlet extends HttpServlet {
    private WorkerManager workerManager;
    private CompanyManager companyManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        workerManager = new WorkerManager(url,user,pass);
        companyManager = new CompanyManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Collection<Worker> workers = null;
        Collection<String> workers1 = null;
        try {
             workers = workerManager.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            workers1 = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("workers",workers);
        request.setAttribute("company",workers1);

        RequestDispatcher rd = request.getRequestDispatcher("AllWorkers.jsp");
      rd.forward(request,response);
    }
}
