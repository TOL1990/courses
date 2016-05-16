package com.courses.spalah.dao.impl;

import com.courses.spalah.model.Client;
import com.courses.spalah.service.ClientService;
import org.hibernate.mapping.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Leonid on 15.05.2016.
 */
@RunWith(JUnit4.class)
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
    @Test
    public void mainTest()throws Exception
    {
        Client client = new Client(INN,FIRST_NAME,LAST_NAME);
        save();
        findByInn();
        updateClient();
        delete();
    }
    public void save() throws Exception {
        ClientDaoImpl clientDao= new ClientDaoImpl(entityManager);
        ArrayList allClients = (ArrayList) clientDao.getAllClient();

        int startSize = allClients.size();

        Client client = new Client();
        client.setFirstName(FIRST_NAME);
        client.setLastName(LAST_NAME);
        client.setInn(INN);

        clientDao.save(client);
        allClients = (ArrayList) clientDao.getAllClient();
        assertEquals(startSize + 1, allClients.size());
//        delete();
    }
    public void findByInn() throws Exception {
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(INN);
        assertEquals(FIRST_NAME, client.getFirstName());
        assertEquals(LAST_NAME, client.getLastName());

    }



    public void delete() throws Exception {
//        init();
        ClientDaoImpl clientDao= new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(INN);

        ArrayList atStartClients = (ArrayList) clientDao.getAllClient();
        int startSize = atStartClients.size();
        clientDao.delete(client);
        atStartClients = (ArrayList) clientDao.getAllClient();

        assertEquals(startSize - 1, atStartClients.size());
//        close();
    }

    public void getAllClient() throws Exception {

    }

    public void getAllBills() throws Exception {

    }

    public void countClients() throws Exception {

    }

    public void updateClient() throws Exception {
        ClientDaoImpl clientDao= new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(INN);
        client.setFirstName("Pan");
        client.setLastName("Banan");
        clientDao.updateClient(client.getInn(), client);

        client = clientDao.findByInn(INN);
        assertEquals("Pan",client.getFirstName());
        assertEquals("Banan",client.getLastName());


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