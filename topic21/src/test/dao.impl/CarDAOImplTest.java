package dao.impl;

import dao.Factory;
import entity.Car;
import entity.Owner;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Leonid on 12.05.2016.
 */
public class CarDAOImplTest extends Assert{
    Owner carOwner = new Owner("test_firsName", "test_lastName", "test_phone");
    String developer = "test_developer";
    String model = "test_model";
    String vin = "test_vin";
    String describe = "test_describe";
    int year = 1111;
    Car car = new Car(carOwner,developer, model, vin, describe, year);

    @Test
    public void addCar() throws Exception {
      //  не коректный тест
        ArrayList cars = (ArrayList) Factory.getInstance().getCarDAO().getAllCars();
        int carsSize = cars.size();
        Factory.getInstance().getCarDAO().addCar(car);
        ArrayList newcars = (ArrayList) Factory.getInstance().getCarDAO().getAllCars();
        assertEquals(cars.size()+ 1, newcars.size());
    }

    @Test
    public void updateCar() throws Exception {

    }

    @Test
    public void getCarById() throws Exception {

    }

    @Test
    public void getAllCars() throws Exception {

    }

    @Test
    public void deleteCar() throws Exception {

    }

    @Test
    public void getCarsByOwner() throws Exception {

    }
}