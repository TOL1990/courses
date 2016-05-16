package com.courses.spalah.dao;

import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Leonid on 14.05.2016.
 */
public interface ClientDAO extends Serializable {

    Client findByInn(Long inn);
    void save(Client client);
    List<Client> getAllClient();
    List<Bill> getAllBills();
    int countClients();
    void updateClient(Long clientInn, Client client);
    public void delete(Client client);
}
