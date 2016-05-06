package home12.Dao;

import home12.Core.Car;
import home12.Core.Lot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid on 31.03.2016.
 */
public class LotDao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public void addLot(int car_id, int owner_id, int price)
    {
        
    }

    public List<Lot> getAllLots() throws SQLException {

        //не доработана ффункция
        Lot lot = new Lot();
        List lots = new ArrayList();
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);
        String quer1y = "SELECT car_id, developer, model, vin, created, describe_more, owner_id FROM carmarketschema.cars";
        String query = "USE carmarketschema ;\n" +
                "SELECT lot.lot_id, lot.price, cars.developer, cars.model, cars.vin, cars.created, " +
                "cars.describe_more, owners.firstname, owners.owner_id, owners.lastname, owners.mobilenumber\n" +
                "FROM cars INNER JOIN owners ON owners.owner_id = cars.owner_id INNER JOIN lot ON cars.car_id = lot.car_id";
        Statement statement = conn.createStatement();
        ResultSet resSet = statement.executeQuery(query);
        while (resSet.next()) {
            int car_id = resSet.getInt("car_id");
            int owner_id = resSet.getInt("owner_id");
            int lot_id = resSet.getInt("lot_id");
            String developer = resSet.getString("developer");
            String model = resSet.getString("model");
            String vin = resSet.getString("vin");
            String describe_more = resSet.getString("describe_more");
            int created = resSet.getInt("created");
            lots.add(new Car(car_id, developer, model, vin, describe_more, created, owner_id));
        }
        lots=null;
        return lots;

    }
}
