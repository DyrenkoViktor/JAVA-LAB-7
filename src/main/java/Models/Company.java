package Models;

import DatabaseConnection.CityManager;
import DatabaseConnection.CompanyManager;
import java.sql.*;
import java.util.*;
public class Company {

    private int id;
    private String name;
    private String phoneCompany;
    private int idCity;
    private String nameCity;


    public Company(String name, String phoneCompany, int idCity){
        this.name = name;
        this.phoneCompany = phoneCompany;
        this.idCity = idCity;
    }

    public Company(int id, String name, String phoneCompany, String nameCity){
        this.id=id;
        this.name = name;
        this.phoneCompany = phoneCompany;
        this.nameCity = nameCity;
    }

    public Company(int id, String name, String phoneCompany, int idCity,String nameCity){
        this.id=id;
        this.name = name;
        this.phoneCompany = phoneCompany;
        this.idCity = idCity;
        this.nameCity=nameCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }





    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneCompany='" + phoneCompany + '\'' +
                ", idCity=" + nameCity +
                '}';
    }



    public static void main(String[] args) throws SQLException{
        Company company1 = new Company("Softserve","23-55-15",1);
        Company company2 = new Company("Glovo","034-43-11-231",2);
        Company company3 = new Company("Happy","765-09-00",1);
        Company company4 = new Company("Okko","321-45-22",2);
        Company company5 = new Company("Love","098-12-90-098",2);

        CompanyManager manager = new CompanyManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");
        CityManager cityManager = new CityManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");

//        manager.createTableCompany();
//
//        manager.addCompany(company1);
//        manager.addCompany(company2);
//        manager.addCompany(company3);
//        manager.addCompany(company4);
//        manager.addCompany(company5);
//
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }


//        Company company = manager.getCompanyById(10);
//        System.out.println(company);
//        Collection<String> name = cityManager.getAllNames();
//        for (String nam: name
//             ) {
//            System.out.println(nam);
//        }

//        Collection<Company> companies = manager.selectCompanyForCity("Ternopil");
//        for (Company comp: companies
//             ) {
//            System.out.println(comp);
//        }
//Collection<String> name = manager.getAllNames();
//        for (String nam: name
//             ) {
//            System.out.println(nam);
//        }

//        System.out.println(manager.getIdByName("Okko"));
        //SELECT OPERATIONS

//        1) SELECT ALL COMPANIES
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//
//
//        2) SELECT COMPANY WHICH ARE LOCATED IN SPECIFIC CITY
//       Collection<Company> companies = manager.selectWorkerForCity("Chernivtsi");
//        for (Company company : companies
//                ) {
//            System.out.println(company);
//        }
//
//
//
//        UPDATE OPERATION
//        UPDATE PHONE COMPANY
//        manager.updatePhone("22-222-22","Chernivtsi");
//                Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//        DELETE INFROMATION
//
//
//        //1) DELETE COMPANY FOR NAME
//        manager.deleteForName("Okko");
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//             ) {
//            System.out.println(company);
//        }
//
//
//
//        2) DELETE ALL COMPANIES
//        manager.deleteAll();
//        Collection<Company> companies = manager.selectAll();
//        for (Company company: companies
//        ) {
//            System.out.println(company);
//        }

        //manager.closeConn();
    }
}
