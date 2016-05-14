package dao.impl;

import dao.CarDAO;
import entity.Car;
import entity.Owner;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Leonid on 06.05.2016.
 */
public class CarDAOImpl implements CarDAO {
    @Override
    public void addCar(Car car) throws SQLException {

    }

    @Override
    public void updateCar(Long car_id, Car car) throws SQLException {

    }

    @Override
    public Car getCarById(Long car_id) throws SQLException {
        return null;
    }

    @Override
    public Collection getAllCars() throws SQLException {
        Session session = null;
        List cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cars = session.createCriteria(Car.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }

    @Override
    public void deleteCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getCarsByOwner(Owner owner) throws SQLException {
//Не пашет метод
       /* List cars = new ArrayList<Car>();
        ArrayList carTemp = (ArrayList) getAllCars();
        Iterator iterator = carTemp.iterator();
        while (iterator.hasNext())
        {
            Car car = (Car) iterator.next();
            if(car.getOwner().getOwner_id() == owner.getOwner_id())
            {
                cars.add(car);
            }
        }
        return cars;
        }*/
        Session session = null;
        List cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long ownerId = owner.getOwner_id();
            Query query = session.createQuery("from Car as car where owner.id =:ownerId").setLong("ownerId", ownerId);
//            Query query = session.createQuery("from Car where owner = :ownerparam");
//            query.setParameter("ownerparam", owner);
            cars = (List<Car>) query.list();
            System.out.println(cars);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }



}
