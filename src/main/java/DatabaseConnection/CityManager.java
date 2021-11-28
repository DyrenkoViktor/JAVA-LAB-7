package DatabaseConnection;

import Models.City;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CityManager{

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public CityManager(String url, String user, String pass) {

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

    public void createTableCity() throws SQLException{

        String t="CREATE TABLE city(Id_city INT(15) NOT NULL AUTO_INCREMENT , Name_city VARCHAR (30) NOT NULL, PRIMARY KEY (Id_city));";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(t);
    }



    //ADD CITY
    public void addCity(City city) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO city(Name_city) VALUES(?);");
        stmt.setString(1,city.getName());

        stmt.execute();
    }


    public Collection<City> selectAll() throws SQLException{
        connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;

        Collection<City> cities = new ArrayList<City>();
        rs = stmt.executeQuery("SELECT * FROM city;");

        while(rs.next()){
           City city = new City(rs.getInt("Id_city"),rs.getString("Name_city"));
            cities.add(city);
        }

        return cities;
    }

    public Collection<String> getAllNames() throws SQLException{
        connect();
        Collection<String> names=new ArrayList<String>();
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT Name_city FROM city;");
        while(rs.next()){
            String name = rs.getString("Name_city");
            names.add(name);
        }

        return names;
    }

    public int getIdCityByName(String name) throws SQLException{
        int id = 0;
        connect();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT Id_city FROM city WHERE Name_city=?;");
        stmt.setString(1,name);
        rs = stmt.executeQuery();
        while (rs.next()){
            id= rs.getInt("Id_city");
        }
        return id;
    }
    //DELETE OPERATIONS
    public void deleteTable() throws SQLException {

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE city;");

    }


    public void deleteCity(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM city WHERE Id_city=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();

    }

}

