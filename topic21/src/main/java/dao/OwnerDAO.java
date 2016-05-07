package dao;

import entity.Owner;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Leonid on 06.05.2016.
 */
public interface OwnerDAO extends Serializable{
    public void addOwner(Owner owner) throws SQLException;
    public void updateBus(Long Owner_id, Owner owner) throws SQLException;
    public Owner getOwnerById(Long Owner_id) throws SQLException;
    public Collection getAllOwners() throws SQLException;
    public void deleteOwner(Owner owner) throws SQLException;

}
