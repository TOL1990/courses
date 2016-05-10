package dao;

import entity.Car;
import entity.Owner;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Leonid on 06.05.2016.
 */
public interface CarDAO extends Serializable {
    public void addCar (Car car) throws SQLException;
    public void updateCar (Long car_id, Car car) throws SQLException;
    public Car getCarById(Long car_id) throws SQLException;
    public Collection getAllCars() throws SQLException;
    public void deleteCar(Car car) throws SQLException;
    public Collection getCarsByOwner(Owner owner) throws SQLException;

}
