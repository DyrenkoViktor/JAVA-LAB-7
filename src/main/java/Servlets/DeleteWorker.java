package Servlets;

import DatabaseConnection.WorkerManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteWorker", value = "/delete")
public class DeleteWorker extends HttpServlet {

    private WorkerManager workerManager;
    private String url;
    private String user;
    private String pass;

    @Override
    public void init(){
        url = "jdbc:mysql://localhost:3306/webApp";
        user = "root";
        pass = "Dyrenko Viktor";

        workerManager = new WorkerManager(url,user,pass);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("deleteId"));
        try {
            workerManager.deleteWorker(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/lab7_1_war_exploded/AllWorkers");

    }

}
