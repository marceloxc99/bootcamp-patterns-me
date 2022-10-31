package singleton;

import java.sql.SQLException;

public class SingletonMysql {

    public static void main(String[]arg) throws SQLException {
        MysqlDBClient mysqlDBclient1 = MysqlDBClient.getClient();
        mysqlDBclient1.showTables();
        MysqlDBClient mysqlDBclient2 = MysqlDBClient.getClient();
        mysqlDBclient2.showTables();
        MysqlDBClient mysqlDBclient3 = MysqlDBClient.getClient();
        mysqlDBclient3.showTables();
    }
}
