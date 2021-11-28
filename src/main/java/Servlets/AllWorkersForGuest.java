package Servlets;

import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;
import Models.Worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AllWorkersForGuest", value = "/AllWorkersForGuest")
public class AllWorkersForGuest extends HttpServlet {
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

        RequestDispatcher rd = request.getRequestDispatcher("AllWorkersForGuest.jsp");
        rd.forward(request,response);
    }
}
