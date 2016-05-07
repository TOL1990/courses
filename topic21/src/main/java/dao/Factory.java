package dao;

import dao.impl.CarDAOImpl;
import dao.impl.LotDAOImpl;
import dao.impl.OwnerDAOImpl;

/**
 * Created by Leonid on 06.05.2016.
 */
public class Factory {
    private static OwnerDAO ownerDAO = null;
    private static CarDAO carDAO = null;
    private static LotDAO lotDAO = null;
    private static Factory instance = null;

    public static synchronized  Factory getInstance()
    {
        if(instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }
    public static synchronized  OwnerDAO getOwnerDAO()
    {
        if(ownerDAO == null)
        {
            ownerDAO = new OwnerDAOImpl();
        }
        return ownerDAO;
    }
    public static synchronized  CarDAO getCarDAO()
    {
        if(carDAO == null)
        {
            carDAO = new CarDAOImpl();
        }
        return carDAO;
    }
    public static synchronized  LotDAO geLotDAO()
    {
        if(lotDAO == null)
        {
            lotDAO = new LotDAOImpl();
        }
        return lotDAO;
    }


}
