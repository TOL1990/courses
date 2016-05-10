package dao;

import entity.Car;
import entity.Lot;
import entity.Owner;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Leonid on 06.05.2016.
 */
public interface LotDAO {
    public Collection getLotsByOwner(Owner owner) throws SQLException;
    public Collection getLotsByCar(Car car) throws SQLException;

    public void addLot(Lot lot) throws SQLException;
    public void updateLot (Long lot_id, Lot lot) throws SQLException;
    public Lot getLotById(Long lot_id) throws SQLException;
    public Collection getAllLots() throws SQLException;
    public void deleteLot(Lot lot) throws SQLException;
}
