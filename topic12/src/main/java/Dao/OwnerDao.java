package Dao;

import Core.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Leonid on 31.03.2016.
 */
public class OwnerDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public void addOwner(String firstName, String lastName, String mobilePhone) throws SQLException {
        String query = "INSERT INTO carmarketschema.owners (firstname, lastname, mobilenumber) VALUES (?,?,?)";
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, mobilePhone);
            statement.executeUpdate();

        } finally {
            DAOUtils.close(statement);
        }
    }

    public Owner getOwnerById(int ownerId) {
        Owner owner = new Owner();


        return owner;
    }
}
