package Servlets;

import DatabaseConnection.CompanyManager;
import DatabaseConnection.WorkerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteCompany", value = "/deletecompany")
public class DeleteCompany extends HttpServlet {


    private CompanyManager companyManager;
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

        int id = Integer.parseInt(request.getParameter("deleteIdCompany"));
        try {
            companyManager.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/lab7_1_war_exploded/AllCompanies");

    }
}
