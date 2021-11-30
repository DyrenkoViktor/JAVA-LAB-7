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

@WebServlet(name = "FilterByCity", value = "/FilterByCity")
public class FilterByCity extends HttpServlet {
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


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameCity = request.getParameter("filterByCity");
        Collection<Company> companies = null;

        try {
            companies = companyManager.selectCompanyForCity(nameCity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!companies.isEmpty()) {
            request.setAttribute("nameCity", nameCity);
            request.setAttribute("companies",companies);
            RequestDispatcher rd = request.getRequestDispatcher("FilterCompany.jsp");
            rd.forward(request,response);
        }

        else{
            request.setAttribute("nameCity", nameCity);
            request.setAttribute("NotFound","Not found companies at "+nameCity);
            RequestDispatcher rd = request.getRequestDispatcher("FilterCompany.jsp");
            rd.forward(request, response);
        }
    }
}
