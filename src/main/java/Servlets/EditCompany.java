package Servlets;

import DatabaseConnection.CityManager;
import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;
import Models.City;
import Models.Company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "EditCompany", value = "/editcompany")
public class EditCompany extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Company company = null;
     Collection<String> cities = null;
     int id = Integer.parseInt(request.getParameter("editIdCompany"));

        try {
            company = companyManager.getCompanyById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("companyId",company.getId());
        request.setAttribute("companyName",company.getName());
        request.setAttribute("companyPhone",company.getPhoneCompany());
        request.setAttribute("codecity",company.getNameCity());
        request.setAttribute("codesCity",cities);

        RequestDispatcher rd = request.getRequestDispatcher("EditCompany.jsp");
        rd.forward(request,response);

    }
}
