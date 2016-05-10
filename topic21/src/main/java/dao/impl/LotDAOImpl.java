package dao.impl;

import dao.LotDAO;
import entity.Car;
import entity.Lot;
import entity.Owner;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Leonid on 06.05.2016.
 */
public class LotDAOImpl implements LotDAO {
    @Override
    public Collection getLotsByOwner(Owner owner) throws SQLException {
        return null;
    }

    @Override
    public Collection getLotsByCar(Car car) throws SQLException {
        return null;
    }

    @Override
    public void addLot(Lot lot) throws SQLException {

    }

    @Override
    public void updateLot(Long lot_id, Lot lot) throws SQLException {

    }

    @Override
    public Lot getLotById(Long lot_id) throws SQLException {
        return null;
    }

    @Override
    public Collection getAllLots() throws SQLException {
        return null;
    }

    @Override
    public void deleteLot(Lot lot) throws SQLException {

    }
}
