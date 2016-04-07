package Dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Leonid on 01.04.2016.
 */
public class DBProcessor {
    private Connection connection;
    public DBProcessor(){
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection(String url, String username, String password)
    {
        if(connection != null) return connection;

        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
