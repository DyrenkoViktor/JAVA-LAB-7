package Servlets;

import DatabaseConnection.CityManager;
import Models.City;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AllCitiesForGuest", value = "/AllCitiesForGuest")
public class AllCitiesForGuest extends HttpServlet {
    private CityManager cityManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        cityManager = new CityManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<City> cities = null;

        try {
            cities = cityManager.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("cities",cities);
        RequestDispatcher rd = request.getRequestDispatcher("AllCitiesForGuest.jsp");
        rd.forward(request,response);

    }
}
