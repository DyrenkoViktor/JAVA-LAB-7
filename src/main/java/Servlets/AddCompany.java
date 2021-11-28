package Servlets;

import DatabaseConnection.CityManager;
import DatabaseConnection.CompanyManager;
import Models.City;
import Models.Company;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AddCompany", value = "/AddCompany")
public class AddCompany extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> cities = null;
        CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp", "root","Dyrenko Viktor");
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("citiesId",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AddCompany.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> cities = null;
        CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp", "root","Dyrenko Viktor");
        try {
            cities = cityManager.getAllNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("citiesId",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AddCompany.jsp");
        rd.forward(request,response);
    }


}
