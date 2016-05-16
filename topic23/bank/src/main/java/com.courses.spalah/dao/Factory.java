package com.courses.spalah.dao;

import com.courses.spalah.dao.impl.ClientDaoImpl;

/**
 * Created by Leonid on 15.05.2016.
 */
public class Factory {
    private static ClientDAO clientDAO = null;
    private static BillDAO billDAO = null;
    private static TransactionDAO transactionDAO = null;
    private static Factory instance = null;

    public static synchronized  Factory getInstance()
    {
        if(instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }
//    public static synchronized  ClientDAO getClientDAO()
//    {
//        if(clientDAO == null)
//        {
//            clientDAO = new ClientDaoImpl();
//        }
//        return clientDAO;
//    }
}
