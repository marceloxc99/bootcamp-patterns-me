package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDBClient {
    public static MysqlDBClient client = null;
    public static Connection mysqlClient;

    private MysqlDBClient(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mysqlClient = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcampdb", "root", "1234abcdFF((");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MysqlDBClient getClient()
    {
        if(client == null){
            System.out.println("first time");
            client = new MysqlDBClient();
        }

        return client;
    }

    public void showTables() throws SQLException {
        ResultSet rs = mysqlClient.prepareStatement("show tables").executeQuery();
        while(rs.next()) {
            String s = rs.getString(1);
            System.out.println(s);
        }
    }
}
