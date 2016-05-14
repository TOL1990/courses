package dao.impl;

import dao.Factory;
import entity.Owner;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Leonid on 10.05.2016.
 */
public class OwnerDAOImplTest {

    @Test
    public void addOwner() throws Exception {
        Owner barak = Factory.getInstance().getOwnerDAO().findOwnerByFirstName("Barak");
        assertEquals(barak.getFirstName(), "Barak");
               Owner owner = new Owner("Василий", "Ломаченко", "789987");
        assertNotNull(owner);
        Factory.getInstance().getOwnerDAO().addOwner(owner);
        Owner vasiliy =  Factory.getInstance().getOwnerDAO().findOwnerByFirstName("Василий");
        assertEquals(vasiliy.getFirstName(), "Василий");
    }

    @Test
    public void updateOwner() throws Exception {

    }

    @Test
    public void deleteOwner() throws Exception {

    }
}