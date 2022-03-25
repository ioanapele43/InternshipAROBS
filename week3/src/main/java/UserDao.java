import connection.HikariConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User>{
    HikariConnection hikariConnection=new HikariConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele",3);
    Connection connection;
    @Override
    public Optional<User> get(long id) {
        User user=null;
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection ok. select");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("SELECT * FROM user where idUser=?");
                query.setLong(1,id);
                ResultSet rs = query.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    user=new User(name,address,username,password,role);
                    System.out.println(String.join(", ",name, address,username,password,role));
                }
            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                hikariConnection.releaseConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        List<User> userList=new ArrayList<User>();
        //User user=null;
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection ok. select");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("SELECT * FROM user ");
                ResultSet rs = query.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    //user=new User(name,address,username,password,role);
                    userList.add(new User(name,address,username,password,role));
                    System.out.println(String.join(", ",name, address,username,password,role));
                }
            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                hikariConnection.releaseConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return userList;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
    public static void main(String[] args){
        UserDao userDao=new UserDao();
        userDao.get(1);
    }
}
