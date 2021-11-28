package Servlets;

import DatabaseConnection.WorkerManager;
import Models.User;
import DatabaseConnection.UserManager;
import Models.Worker;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet{

    private UserManager userManager;
    private WorkerManager workerManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
         url = "jdbc:mysql://localhost:3306/webApp";
         user = "root";
         pass = "Dyrenko Viktor";

        userManager = new UserManager(url,user,pass);
        workerManager = new WorkerManager(url,user,pass);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String userName = request.getParameter("nickname");
        String password = request.getParameter("password");

        User user1 = null;
        try {
            user1 =  userManager.getUserForEmailAndPassword(userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user1!=null){

           request.setAttribute("message1",user1.getNickname());
           request.setAttribute("role",user1.getRole());
           if(user1.getRole().equals("admin")) {
               request.getRequestDispatcher("welcome.jsp").forward(request, response);
           }
           else if(user1.getRole().equals("guest")){
               request.getRequestDispatcher("welcomeGuest.jsp").forward(request,response);
           }
        }
        else{
            request.setAttribute("message","Not found such user. Please sign up ");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
