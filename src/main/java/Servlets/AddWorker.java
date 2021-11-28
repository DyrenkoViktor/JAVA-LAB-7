package Servlets;

import DatabaseConnection.CompanyManager;
import Models.Company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AddWorker", value = "/AddWorker")
public class AddWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> companies = null;
        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root","Dyrenko Viktor");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("companiesId",companies);
        RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> companies = null;
        CompanyManager companyManager = new CompanyManager("jdbc:mysql://localhost:3306/webApp", "root","Dyrenko Viktor");
        try {
            companies = companyManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("companiesId",companies);
        RequestDispatcher rd = request.getRequestDispatcher("AddWorker.jsp");
        rd.forward(request,response);
    }
}
