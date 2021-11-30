package DatabaseConnection;

import Models.Worker;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class WorkerManager {

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public WorkerManager(String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    protected void connect() throws SQLException{

        if(conn == null || conn.isClosed()){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                }
                catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                conn = DriverManager.getConnection(url,user,pass);
            }

    }



    public void closeConn() throws SQLException{
        conn.close();
    }


    //TABLE OPERATIONS

    public void createTableWorkers() throws SQLException{

        String t="CREATE TABLE workers(Id_worker INT(15) NOT NULL AUTO_INCREMENT , Surname VARCHAR (30) NOT NULL ," +
                " Name VARCHAR (30) NOT NULL , Lastname VARCHAR(30) NOT NULL , Age INT(2) NOT NULL,"+
                " Salary FLOAT (10) NOT NULL , Experience INT(2) NOT NULL, CodeCompany INT(10), "+
                "FOREIGN KEY(CodeCompany) REFERENCES company(Id_company) ON DELETE CASCADE, PRIMARY KEY(Id_worker) );";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);



    }


    public void deleteTable() throws SQLException{

        String t1 = "DROP TABLE workers;";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t1);
        System.out.println("Deleted table");



    }



    //ADD WORKER


    public void addWorkerToTable(Worker obj) throws SQLException{
        connect();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO workers(Surname,Name,Lastname,Age,Salary,Experience,CodeCompany) VALUES(?,?,?,?,?,?,?);");
        stmt.setString(1,obj.getSurname());
        stmt.setString(2,obj.getName());
        stmt.setString(3,obj.getLastname());
        stmt.setInt(4,obj.getAge());
        stmt.setFloat(5,obj.getSalary());
        stmt.setInt(6,obj.getExperience());
        stmt.setInt(7,obj.getCodeCompany());

        stmt.execute();


        System.out.println("Added 1 worker");

    }


    //SELECT OPERATIONS

    //1) SELECT ALL AVAILABLE WORKERS;

    public Collection<Worker> filterByAge(int flag) throws SQLException{
        connect();
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        if(flag == 0) {
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Age < 25 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 1){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Age >= 25 AND w.Age < 40 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 2){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Age >= 40 AND w.Age < 55 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag ==3){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Age >= 55 AND w.Age <= 60 ORDER BY w.Age;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        return null;
    }


    public Collection<Worker> filterBySalary(int flag) throws SQLException{
        connect();
        Collection<Worker> workers = new ArrayList<Worker>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        if(flag == 0) {
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Salary < 1500 ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 1){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Salary >= 1500 AND w.Salary < 3000 ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag == 2){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Salary >= 3000 AND w.Salary <= 5000 ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        else if(flag ==3){
            rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname,w.Name,w.Lastname,w.Age,w.Salary,w.Experience,c.Name_company AS Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND w.Salary > 5000 ORDER BY w.Salary;");
            while(rs.next()){

                Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
                workers.add(w1);
            }
            return workers;
        }

        return null;
    }

    public Collection<Worker> filterByCompany(String name) throws SQLException{
        connect();
        ResultSet rs = null;
        Collection<Worker> workers1 = new ArrayList<Worker>();

        PreparedStatement stmt = conn.prepareStatement("SELECT workers.Id_worker, workers.Surname,workers.Name, workers.Lastname,workers.Age,workers.Salary, workers.Experience,company.Name_company AS Name_company FROM workers,company WHERE workers.CodeCompany=company.Id_company AND company.Name_company=? ORDER BY workers.Surname;");
        stmt.setString(1,name);

        rs = stmt.executeQuery();
        while(rs.next()){

            Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
            workers1.add(w1);
        }

        return workers1;
    }


    public Worker getWorkerById(int id) throws SQLException{
        Worker worker = null;
        connect();

        ResultSet rs = null;
        PreparedStatement stmt = null;
        stmt = conn.prepareStatement("SELECT w.Id_worker, w.Surname, w.Name, w.Lastname, w.Age, w.Salary, w.Experience, c.Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company AND Id_worker=?;");
        stmt.setInt(1,id);

        rs = stmt.executeQuery();

        while (rs.next()){
            worker = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"), rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));

        }

        return worker;

    }

    public Collection<Worker> selectAll() throws SQLException{
        Collection<Worker> workers = new ArrayList<Worker>();
        connect();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT w.Id_worker, w.Surname, w.Name, w.Lastname, w.Age, w.Salary, w.Experience, c.Name_company FROM workers w, company c WHERE w.CodeCompany=c.Id_company;");

        while(rs.next()){

           Worker w1 = new Worker(rs.getInt("Id_worker"),rs.getString("Surname"),rs.getString("Name"),rs.getString("Lastname"),rs.getInt("Age"),rs.getFloat("Salary"),rs.getInt("Experience"),rs.getString("Name_company"));
           workers.add(w1);
        }

        return workers;
    }

    public void editWorker(Worker worker) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("UPDATE workers SET Surname=?,Name=?,Lastname=?,Age=?,Salary=?,Experience=?, CodeCompany=? WHERE Id_worker=?;");

        stmt.setString(1,worker.getSurname());
        stmt.setString(2,worker.getName());
        stmt.setString(3,worker.getLastname());
        stmt.setInt(4,worker.getAge());
        stmt.setFloat(5,worker.getSalary());
        stmt.setInt(6,worker.getExperience());
        stmt.setInt(7,worker.getCodeCompany());
        stmt.setInt(8,worker.getId());


        stmt.executeUpdate();
    }


    public void deleteWorker(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM workers WHERE Id_worker=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();

    }

}
