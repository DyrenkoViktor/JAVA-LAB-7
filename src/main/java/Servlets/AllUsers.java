package Servlets;

import DatabaseConnection.CityManager;
import DatabaseConnection.UserManager;
import Models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "AllUsers", value = "/AllUsers")
public class AllUsers extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Collection<User> users = null;
        User user1= null;
        try {
            user1 = userManager.getRootUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            users = userManager.selectAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("userId",user1.getId());
        request.setAttribute("userSurname",user1.getSurname());
        request.setAttribute("userName",user1.getName());
        request.setAttribute("userEmail",user1.getEmail());
        request.setAttribute("userNickname",user1.getNickname());
        request.setAttribute("userPassword",user1.getPassword());
        request.setAttribute("userRole",user1.getRole());

        request.setAttribute("users",users);
        RequestDispatcher rd = request.getRequestDispatcher("AllUsers.jsp");
        rd.forward(request,response);

    }

}
