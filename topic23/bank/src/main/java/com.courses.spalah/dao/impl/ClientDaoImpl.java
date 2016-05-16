package com.courses.spalah.dao.impl;

import com.courses.spalah.dao.ClientDAO;
import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Leonid on 14.05.2016.
 */
public class ClientDaoImpl implements ClientDAO {
    private EntityManager entityManager;

    public ClientDaoImpl(EntityManager entityManager) { this.entityManager = entityManager;
    }

    public Client findByInn(Long inn) {
        entityManager.getTransaction().begin();

        Client foundClient = entityManager.find(Client.class, inn);

        entityManager.getTransaction().commit();
        entityManager.close();

        return foundClient;
    }

    public void save(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public List<Client> getAllClient() {
        entityManager.getTransaction().begin();
        List<Client> clients = entityManager.createQuery("from Client", Client.class).getResultList();
        entityManager.getTransaction().commit();
        return clients;
    }

    public List<Bill> getAllBills() {
        return null;
    }

    public int countClients() {

        return getAllClient().size();
    }

    public void updateClient(Long clientInn, Client client) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Client Set firstName=:fname,lastName=:lname, inn=:inn WHERE inn=:inn");
        query.setParameter("inn", clientInn);
        query.setParameter("fname", client.getFirstName());
        query.setParameter("lname", client.getLastName());

        query.executeUpdate();

        entityManager.getTransaction().commit();

    }
    public void delete(Client client)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();

    }
}
