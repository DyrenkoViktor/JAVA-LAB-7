package Models;

import DatabaseConnection.CityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class City {

    private int id;
    private String Name;

    public City(String Name){
        this.Name = Name;
    }
    public City(int id, String Name){
        this.id=id;
        this.Name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public static void main(String[] args) throws SQLException{
        City city1 = new City("Chernivtsi");
        City city2 = new City("Lviv");

        CityManager managerCity = new CityManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");
//        managerCity.createTableCity();
//
//        managerCity.addCity(city1);
//        managerCity.addCity(city2);

        //managerCity.deleteTable();

        //managerCity.deleteInfo();
//        Collection<City> city = new ArrayList<City>();
//
//       city = managerCity.selectAll();
//
//        for (City cities: city
//             ) {
//            System.out.println(cities);
//        }
        // managerCity.closeConn();
    }
}

