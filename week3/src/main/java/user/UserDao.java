package user;

import connection.HikariConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    HikariConnection hikariConnection=new HikariConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele",3);
    Connection connection;
    @Override
    public Optional<User> get(long id) {
        User user=null;
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok. select");
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
                System.out.println("\nConnection NOT ok.select");
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
        //user.User user=null;
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok. select all");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("SELECT * FROM user ");
                ResultSet rs = query.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    //user=new user.User(name,address,username,password,role);
                    userList.add(new User(name,address,username,password,role));
                    System.out.println(String.join(", ",name, address,username,password,role));
                }
            } else {
                System.out.println("\nConnection NOT ok.select all");
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
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok.insert");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("insert into user(name,address,username,password,role) values (?,?,?,?,?);");
                query.setString(1,user.getName());
                query.setString(2,user.getAddress());
                query.setString(3,user.getUsername());
                query.setString(4,user.getPassword());
                query.setString(5,user.getRole());
                query.executeUpdate();



            } else {
                System.out.println("\nConnection NOT ok.insert");
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
    }

    @Override
    public void update(User user, String[] params) {
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok.update");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("update user set name=?, address=?, role=? where username=? and password=?");
                query.setString(1,params[0]);
                query.setString(2,params[1]);
                query.setString(4,user.getUsername());
                query.setString(5,user.getPassword());
                query.setString(3,params[2]);
                query.executeUpdate();



            } else {
                System.out.println("\nConnection NOT ok.update");
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
    }

    @Override
    public void delete(User user) {
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok.delete");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("delete from user where username=?");
                query.setString(1,user.getUsername());
                query.executeUpdate();

            } else {
                System.out.println("\nConnection NOT ok.delete");
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
    }
    public User getUserByUsernameAndPassword(String username,String password) {
        User user=null;
        try {
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("\nConnection ok. select");
                Statement statement = connection.createStatement();
                PreparedStatement query = connection.prepareStatement("SELECT * FROM user where username=? and password=?;");
                query.setString(1,username);
                query.setString(2,password);
                ResultSet rs = query.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");

                    String role = rs.getString("role");
                    user=new User(name,address,username,password,role);
                    System.out.println(String.join(", ",name, address,username,password,role));
                }
            } else {
                System.out.println("\nConnection NOT ok.select");
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
        return user;
    }
    public boolean login(String username, String password){
        if(getUserByUsernameAndPassword(username,password)==null){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        UserDao userDao=new UserDao();
       // userDao.get(1);
        userDao.getAll();
        userDao.save(new User("tryyy","asasd","myyy","1234","client"));
        userDao.getAll();
        String[] updateStrings=new String[3];
        updateStrings[0]="tryyyupd";
        updateStrings[1]="asdsdasd";
        updateStrings[2]="operator";
        userDao.update(new User("tryyy","asasd","myyy","1234","client"),updateStrings);
        userDao.getAll();
        userDao.delete(new User("tryyyupd","asdsdasd","myyy","1234","operator"));
        userDao.getAll();
        System.out.println(userDao.login("ioanap","1234"));

    }
}
