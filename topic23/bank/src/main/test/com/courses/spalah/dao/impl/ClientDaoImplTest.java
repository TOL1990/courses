package com.courses.spalah.dao.impl;

import com.courses.spalah.model.Client;
import com.courses.spalah.service.ClientService;
import org.hibernate.mapping.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Leonid on 15.05.2016.
 */
public class ClientDaoImplTest extends Assert {


    private static final String PERSISTENCE_UNIT = "com.courses.spalah.bank";

    //test Client
    private static final String FIRST_NAME = "TestFirstName";
    private static final String LAST_NAME = "TestLastName";
    private static final Long INN = 1000000000L;

    EntityManager entityManager;
    @Before
    public void init()
    {
         entityManager = initEntityManager();

    }

    @org.junit.Test
    public void save() throws Exception {
        ClientDaoImpl clientDao= new ClientDaoImpl(entityManager);
        ArrayList atStartClients = (ArrayList) clientDao.getAllClient();

        int startSize = atStartClients.size();

        Client client = new Client();
        client.setFirstName(FIRST_NAME);
        client.setLastName(LAST_NAME);
        client.setInn(INN);

        clientDao.save(client);

        assertEquals(startSize + 1, startSize);
    }
    @org.junit.Test
    public void findByInn() throws Exception {
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(1000000000L);
        assertEquals(FIRST_NAME, client.getFirstName());
        assertEquals(LAST_NAME, client.getLastName());

    }


    @Test
    public void delete() throws Exception {

        ClientDaoImpl clientDao= new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(1000000000L);

        ArrayList atStartClients = (ArrayList) clientDao.getAllClient();
        int startSize = atStartClients.size();
        clientDao.delete(client);
        assertEquals(startSize - 1, startSize);
    }

    @org.junit.Test
    public void getAllClient() throws Exception {

    }

    @org.junit.Test
    public void getAllBills() throws Exception {

    }

    @org.junit.Test
    public void countClients() throws Exception {

    }

    @org.junit.Test
    public void updateClient() throws Exception {

    }
    private static EntityManager initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
    @After
    public void close()
    {
        entityManager.close();
    }
}