package dao;

import entity.Car;
import entity.Owner;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Leonid on 06.05.2016.
 */
public interface LotDAO {
    public Collection getLotsByOwner(Owner owner) throws SQLException;
    public Collection getLotsByCar(Car car) throws SQLException;
}
