package DatabaseConnection;

import Models.Company;
import Models.Worker;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CompanyManager {

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public CompanyManager(String url, String user, String pass) {
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
    public void createTableCompany() throws SQLException{

        String t="CREATE TABLE company(Id_company INT(15) NOT NULL AUTO_INCREMENT , Name_company VARCHAR (30) NOT NULL ,"+
                " Phone_company VARCHAR (30) NOT NULL , CodeCity INT(30), FOREIGN KEY (CodeCity) REFERENCES city (Id_city) ON DELETE CASCADE, PRIMARY KEY (Id_company));";
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate(t);
    }


    public void editCompany(Company company) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("UPDATE company SET Name_company=?,Phone_company=?, CodeCity=? WHERE Id_company=?;");

        stmt.setString(1,company.getName());
        stmt.setString(2,company.getPhoneCompany());
        stmt.setInt(3,company.getIdCity());
        stmt.setInt(4,company.getId());

        stmt.executeUpdate();
    }

    public void deleteTableCompany() throws SQLException{

        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("DROP TABLE company;");
    }


    //ADD COMPANY
    public void addCompany(Company company) throws SQLException{
        connect();
        PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO company(Name_company,Phone_company,CodeCity) VALUES (?,?,?);");
        stmt.setString(1,company.getName());
        stmt.setString(2,company.getPhoneCompany());
        stmt.setInt(3,company.getIdCity());

        stmt.execute();


        System.out.println("Added 1 company");
    }



    public int maxId() throws SQLException{
        connect();
        int res=-1;
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT MAX(Id_company) AS Max_Id  FROM company; ");
        if(rs.next()) {
            res = rs.getInt("Max_Id");
        }
         return res;

    }

    //SELECT OPERATIONS

    //1)SELECT ALL COMPANY
    public Collection<Company> selectAll() throws SQLException{
        connect();
        Collection<Company>companies = new ArrayList<Company>();

        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT k.Id_company,k.Name_company,k.Phone_company, com.Name_city FROM company k,city com WHERE k.CodeCity=com.Id_city;");

        while(rs.next()){


           Company company = new Company(rs.getInt("Id_company"),rs.getString("Name_company"),rs.getString("Phone_company"),rs.getString("Name_city"));
            companies.add(company);
        }

        return companies;

    }

    public Company getCompanyById(int id) throws SQLException{
        connect();
        Company company = null;
        ResultSet rs = null;
        PreparedStatement ptmt = conn.prepareStatement("SELECT k.Id_company,k.Name_company,k.Phone_company, com.Name_city FROM company k, city com WHERE k.CodeCity=com.Id_city AND k.Id_company=?;");
        ptmt.setInt(1,id);

        rs = ptmt.executeQuery();

        while (rs.next()){
            company = new Company(rs.getInt("Id_company"),rs.getString("Name_company"),rs.getString("Phone_company"), rs.getString("Name_city"));
        }

        return company;
    }


    //2) SELECT COMPANIES WHICH ARE LOCATED IN SPECIFIC CITY
    public Collection<Company> selectCompanyForCity(String city) throws SQLException{
        ResultSet rs = null;
        Collection<Company> companies = new ArrayList<Company>();
        connect();
        PreparedStatement stmt = this.conn.prepareStatement("SELECT k.Id_company, k.Name_company,k.Phone_company,com.Name_city FROM company k,city com WHERE k.CodeCity=com.Id_city AND  com.Name_city=? ORDER BY k.Name_company;");
        stmt.setString(1,city);
        rs = stmt.executeQuery();

        while(rs.next()){

           Company company = new Company(rs.getInt("Id_company"),rs.getString("Name_company"),rs.getString("Phone_company"),rs.getString("Name_city"));
           companies.add(company);
        }

        return companies;
    }

    public Collection<String> getAllNames() throws SQLException{
        connect();
        Collection<String> names = new ArrayList<String>();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT Name_company FROM company");
        while (rs.next()){
            String temp = rs.getString("Name_company");
            names.add(temp);
        }

        return names;
    }

    public int getIdByName(String name) throws SQLException {
        int id = 0;
        connect();

        ResultSet rs = null;

        PreparedStatement stmt = conn.prepareStatement("SELECT Id_company FROM company WHERE Name_company=?;");
        stmt.setString(1,name);

        rs = stmt.executeQuery();

        while(rs.next()){
            id = rs.getInt("Id_company");
        }

        return id;
    }


    //DELETE OPERATIONS
    public void deleteById(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM company WHERE Id_company=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }

}

