package home12.Dao;


import home12.Core.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid on 31.03.2016.
 */
public class OwnerDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

   private final String SELECT_ALL_OWNERS = "SELECT owner_id,firstname,lastname, mobilenumber FROM carmarketschema.owners";


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
    public List<Owner> getAllOwners() throws SQLException {
        Owner owner = new Owner();
        List owners = new ArrayList();
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(SELECT_ALL_OWNERS);
        while (resSet.next()) {
            int owner_id = resSet.getInt("owner_id");
            String firstName = resSet.getString("firstName");
            String lastName= resSet.getString("lastName");
            String mobileNumber = resSet.getString("mobileNumber");
            owners.add(new Owner(owner_id, firstName, lastName, mobileNumber));
        }

        return owners;
    }
}
