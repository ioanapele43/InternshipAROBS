import java.sql.*;

public class ConnectionToDatabase {
    public static void main(String[] args) {
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("All good.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
           /* if (connection != null) {
                System.out.println("Connection ok.");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM artists";
                ResultSet rs = statement.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String stageName = rs.getString("stage_name");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    Date birthday = rs.getDate("birthday");

                    System.out.println(String.join(", ", String.valueOf(id), stageName, firstName, lastName, email, birthday.toString()));
                }
            } else {
                System.out.println("Connection NOT ok.");
            }*/
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
}
