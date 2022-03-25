import connection.BasicConnection;
import connection.HikariConnection;

import java.sql.*;

public class ConnectionToDatabase {
    Connection connection = null;
    BasicConnection basicConnection=new BasicConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele",3);
    HikariConnection hikariConnection=new HikariConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele",3);
    public void seeShowsTable(){
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
           // connection= basicConnection.getConnection();
            connection= hikariConnection.getConnection();
            if (connection != null) {
                System.out.println("Connection ok. select");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM shows";
                ResultSet rs = statement.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("idshow");
                    String title = rs.getString("title");
                    String director = rs.getString("director");
                    Date releaseDate = rs.getDate("releasedate");
                    Date lastModification = rs.getDate("lastModification");

                    System.out.println(String.join(", ", String.valueOf(id), title,director,releaseDate.toString(),lastModification.toString()));
                }
            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //basicConnection.releaseConnection(connection);
            try {
                hikariConnection.releaseConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
           /* try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
    public void insertShowsTable(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
            if (connection != null) {
                System.out.println("Connection ok.insert");
                Statement statement = connection.createStatement();
                String query = "insert into shows(idshow,title,director,releasedate) values (3,'aaa','ddd',now());";
                boolean rs=statement.execute(query);


            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void updateShowsTable(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
            if (connection != null) {
                System.out.println("Connection ok. update");
                Statement statement = connection.createStatement();
                String query = "update shows set director='ddddd' where idshow=3;";
                boolean rs=statement.execute(query);


            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteShowsTable(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
            if (connection != null) {
                System.out.println("Connection ok. delete ");
                Statement statement = connection.createStatement();
                String query = "delete from shows where idshow=3";
                boolean rs=statement.execute(query);


            } else {
                System.out.println("Connection NOT ok.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ConnectionToDatabase connectionToDatabase=new ConnectionToDatabase();
        //connectionToDatabase.seeShowsTable();
        connectionToDatabase.insertShowsTable();
        connectionToDatabase.updateShowsTable();
        connectionToDatabase.seeShowsTable();
        connectionToDatabase.deleteShowsTable();
        connectionToDatabase.seeShowsTable();
    }
}
