package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnection implements ConnectionPool{
    private String connectionString;
    private String user;
    private String password;
    private int maxSize;

    private List<Connection> connectionListAvailable=new ArrayList<Connection>();
    private List<Connection> connectionListUsed=new ArrayList<Connection>();

    public BasicConnection(String connectionString,String user,String password,int maxSize)  {
        this.connectionString=connectionString;
        this.user=user;
        this.password=password;
        this.maxSize=maxSize;
        for(int i=0;i<maxSize;i++){
            Connection conn=null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arobs-internship", "student", "pele");
                if(conn!=null) {
                    connectionListAvailable.add(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



        }
    }
    @Override
    public Connection getConnection() {
        if(connectionListAvailable.size()>0){
            Connection conn= connectionListAvailable.remove(connectionListAvailable.size()-1);
            connectionListUsed.add(conn);
            return conn;
        }
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {
        connectionListUsed.remove(connection);
        connectionListAvailable.add(connection);
    }

}
