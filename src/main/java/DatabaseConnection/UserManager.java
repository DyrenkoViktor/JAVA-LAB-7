package DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Models.User;


public class UserManager {

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    public UserManager(String url, String user, String pass) {
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

    public void addUser(User user) throws SQLException{

        connect();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (Surname,NameUser,Email,Nickname,Password,RoleUser) VALUES(?,?,?,?,?,?);");
        stmt.setString(1,user.getSurname());
        stmt.setString(2,user.getName());
        stmt.setString(3,user.getEmail());
        stmt.setString(4,user.getNickname());
        stmt.setString(5,user.getPassword());
        stmt.setString(6,"guest");
        stmt.executeUpdate();
        stmt.close();
        closeConn();
    }

    public List<User> selectAllUser() throws SQLException{

        connect();
        List<User> res = new ArrayList<User>();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM users WHERE ID_user>1;");
        while(resultSet.next()){
             int id = resultSet.getInt("ID_user");
             String surname = resultSet.getString("Surname");
             String name = resultSet.getString("NameUser");
             String email = resultSet.getString("Email");
             String nickname = resultSet.getString("Nickname");
             String password = resultSet.getString("Password");
             String role = resultSet.getString("RoleUser");

             User user = new User(id,surname,name,email,nickname,password,role);
             res.add(user);
        }

        resultSet.close();
        stmt.close();
        closeConn();
        return res;
    }

    public void deleteUser(int id) throws SQLException{
        connect();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE ID_user=?;");
        stmt.setInt(1,id);
        stmt.executeUpdate();
        stmt.close();
        closeConn();
    }

    public boolean getUserByNickname(String nickname) throws SQLException{
        connect();

        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE Nickname=?;");
        stmt.setString(1,nickname);
        rs = stmt.executeQuery();

        if(rs.next()){
            return true;
        }

        else {
            return false;
        }

    }

    public User getUser(int id) throws SQLException{
        User user=null;
        connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE ID_user=?;");
        stmt.setInt(1,id);

        ResultSet resultSet = stmt.executeQuery();

        if(resultSet.next()){
            String surname = resultSet.getString("Surname");
            String name = resultSet.getString("NameUser");
            String email = resultSet.getString("Email");
            String nickname = resultSet.getString("Nickname");
            String password = resultSet.getString("Password");
            String role = resultSet.getString("RoleUser");
            user = new User(id,surname,name,email,nickname,password,role);
        }

        resultSet.close();
        stmt.close();
        return user;

    }

    public User getRootUser() throws SQLException{
        User user = null;
        connect();
        Statement stmt = conn.createStatement();


        ResultSet resultSet = stmt.executeQuery("SELECT * FROM users WHERE ID_user=1;");

        if (resultSet.next()){
            int id = resultSet.getInt("ID_user");
            String surname = resultSet.getString("Surname");
            String name = resultSet.getString("NameUser");
            String email = resultSet.getString("Email");
            String nickname = resultSet.getString("Nickname");
            String password = resultSet.getString("Password");
            String role = resultSet.getString("RoleUser");
            user = new User(id,surname,name,email,nickname,password,role);
        }

        stmt.close();
        resultSet.close();
        closeConn();
        return  user;

    }

    public User getUserForEmailAndPassword(String nickname, String password) throws SQLException{
        User user=null;

        connect();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE Nickname = ? AND Password=?;");
        stmt.setString(1,nickname);
        stmt.setString(2,password);

        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()){
            int id = resultSet.getInt("ID_user");
            String surname = resultSet.getString("Surname");
            String name = resultSet.getString("NameUser");
            String email = resultSet.getString("Email");
            String role = resultSet.getString("RoleUser");
            user = new User(id,surname,name,email,nickname,password,role);
        }

        stmt.close();
        resultSet.close();
        closeConn();
        return  user;
    }


    public void updateRole(String role, int id) throws SQLException{
        connect();

        PreparedStatement stmt = conn.prepareStatement("UPDATE users SET RoleUser=? WHERE ID_user=?;");
        stmt.setString(1,role);
        stmt.setInt(2,id);
        stmt.executeUpdate();

    }
}
