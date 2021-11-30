package Servlets;

import DatabaseConnection.CompanyManager;
import DatabaseConnection.UserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteUser", value = "/deleteUser")
public class deleteuser extends HttpServlet {
    private UserManager userManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        userManager = new UserManager(url,user,pass);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteIdUser"));

        try {
            userManager.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/lab7_1_war_exploded/AllUsers");
    }
}
