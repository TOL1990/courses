package Service;

import Core.Car;
import Dao.CarDao;
import Dao.DAOUtils;
import Dao.DBProcessor;
import Dao.OwnerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid on 05.04.2016.
 */
public class DaoServices {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jh23q.9";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public void addOwner(String firstName, String lastName, String mobilePhone) throws SQLException {
        OwnerDao ownerDao = new OwnerDao();
        ownerDao.addOwner(firstName, lastName, mobilePhone);
    }

    public void addCar(String developer, String model, String vin, int created, String describe_more, int owner_id) {
        CarDao carDao = new CarDao();
        carDao.addCar(developer, model, vin, created, describe_more, owner_id);
    }

    public  void addLot(int carId, int ownerId, int price ) throws SQLException {
        CarDao carDao = new CarDao();
        Car car = carDao.getCarById(carId);


        OwnerDao owner = new OwnerDao();
        owner.getOwnerById(ownerId);


    }
    public List<Car> getAllCars() throws SQLException {
        CarDao carDao = new CarDao();
        ArrayList carList = carDao.getAllCar();
        return carList;
    }
}
