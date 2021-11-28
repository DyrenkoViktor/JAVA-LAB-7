package Servlets;

import DatabaseConnection.CityManager;
import DatabaseConnection.CompanyManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteCity", value = "/deletecity")
public class DeleteCity extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("deleteIdCity"));

        try {
            cityManager.deleteCity(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/lab7_1_war_exploded/AllCities");
    }
}
