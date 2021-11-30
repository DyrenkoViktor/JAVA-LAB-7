package Servlets;

import DatabaseConnection.UserManager;
import Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value="/registrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UserManager userManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init() {
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        userManager = new UserManager(url, user, pass);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String surname = request.getParameter("surname");
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String nickname = request.getParameter("nickname");
       String password1 = request.getParameter("password1");
       String password2 = request.getParameter("password2");
       boolean isMatch = false;

        try {
            isMatch = userManager.getUserByNickname(nickname);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(surname.isEmpty() || name.isEmpty() || email.isEmpty() || nickname.isEmpty() || password1.isEmpty() || password2.isEmpty() || !password1.equals(password2) || isMatch==true) {
            request.setAttribute("incorrect_data","Please check information. !Fields cannot be empty  !Passwords cannnot be match  !Nickname cannot dublicate");
        }

        else{
           User user = new User(surname,name,email,nickname,password1,"guest");
           try {
               userManager.addUser(user);
           } catch (SQLException e) {
               e.printStackTrace();
           }

           request.setAttribute("success_create","You registration is successful. Please log in");
        }
        request.getRequestDispatcher("registration.jsp").forward(request,response);


    }


}