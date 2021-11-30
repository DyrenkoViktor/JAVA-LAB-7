package Servlets;

import DatabaseConnection.CityManager;
import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;
import Models.Company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AllCompaniesServlet", value = "/AllCompanies")
public class AllCompaniesServlet extends HttpServlet {

    private CompanyManager companyManager;
    private CityManager cityManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        companyManager = new CompanyManager(url,user,pass);
        cityManager = new CityManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<Company> companies = null;
        Collection<String> names = null;

        try {
            companies = companyManager.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            names = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("companies",companies);
        request.setAttribute("listcity",names);

        RequestDispatcher rd = request.getRequestDispatcher("AllCompanies.jsp");
        rd.forward(request,response);
    }


}
