package Dao;

import java.sql.*;

/**
 * Created by Leonid on 25.03.2016.
 */
public class carMarketDaoVerse1 {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void executeQuery(String query)
    {


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}


