package home12.Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Leonid on 25.03.2016.
 */
public class CarMarketDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public void addOwner(String firstName, String lastName, String mobilePhone) throws SQLException {
       OwnerDao ownerDao = new OwnerDao();
        ownerDao.addOwner(firstName, lastName, mobilePhone);
    }

    private void init() {
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
    }

    public void addCar(String developer, String model, String vin, int created, int price, String describe_more, int owner_id) {
        CarDao carDao = new CarDao();
        carDao.addCar(developer, model, vin, created, describe_more, owner_id);
    }



}
