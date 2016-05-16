package com.courses.spalah.service;

import com.courses.spalah.model.Client;

import javax.persistence.EntityManager;

/**
 * Created by Leonid on 14.05.2016.
 */
public class ClientService {
    private EntityManager entityManager;

    public ClientService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Client findByInn(Long inn)
    {
        entityManager.getTransaction().begin();

        Client foundClient = entityManager.find(Client.class, inn);

        entityManager.getTransaction().commit();
        entityManager.close();

        return foundClient;
    }
    public void save(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client); // сохранять сущности очень просто. Вызываем метод persist.
        entityManager.getTransaction().commit();
    }
}
