package Models;

import DatabaseConnection.UserManager;

import java.sql.SQLException;
import java.util.Collection;

public class User {

    private int id;
    private String Surname;
    private String Name;
    private String email;
    private String nickname;
    private String password;
    private String role;


    public User(int id, String Surname, String Name, String email, String nickname, String password, String role){
        this.id = id;
        this.Surname = Surname;
        this.Name = Name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }

    public User(String Surname, String Name, String email, String nickname, String password, String role){
        this.Surname = Surname;
        this.Name = Name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static void main(String args[]) throws  SQLException{


        UserManager userManager = new UserManager("jdbc:mysql://localhost:3306/webApp","root","Dyrenko Viktor");
        Collection<User> users = null;

       User user1 = null;
       users = userManager.selectAllUser();
boolean isMatch;
isMatch = userManager.getUserByNickname("viktor");
        System.out.println(isMatch);

    }
}
