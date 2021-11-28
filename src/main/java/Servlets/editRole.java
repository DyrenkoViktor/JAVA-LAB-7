package Servlets;

import DatabaseConnection.UserManager;
import DatabaseConnection.WorkerManager;
import Models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editRole", value = "/editRole")
public class editRole extends HttpServlet {
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

        User user = null;

        int id = Integer.parseInt(request.getParameter("editRoleUser"));

        try {
            user = userManager.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("nickname",user.getNickname());
        request.setAttribute("idUser",user.getId());
        request.setAttribute("surnameUser",user.getSurname());
        request.setAttribute("nameUser",user.getName());
        request.setAttribute("emailUser",user.getEmail());
        request.setAttribute("nicknameUser",user.getNickname());
        request.setAttribute("passwordUser",user.getPassword());
        request.setAttribute("roleUser",user.getRole());

        RequestDispatcher rd = request.getRequestDispatcher("EditRoleUser.jsp");
        rd.forward(request,response);

    }
}
