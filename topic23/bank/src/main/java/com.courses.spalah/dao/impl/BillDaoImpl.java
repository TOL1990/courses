package com.courses.spalah.dao.impl;

import com.courses.spalah.dao.BillDAO;
import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Leonid on 15.05.2016.
 */
public class BillDaoImpl implements BillDAO {
    private EntityManager entityManager;
    public BillDaoImpl(EntityManager entityManager) { this.entityManager = entityManager;
    }

    public Collection<Bill> getBillsByClient(Client client) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Bill as bill where client.inn=:client");
//        query.setParameter("client", client.getInn());
        query.setParameter("client", client.getInn());

        ArrayList<Bill> bills = (ArrayList<Bill>) query.getResultList();
        entityManager.close();
        return bills;
    }
    public Bill findByNumber(Long billNumber){
        entityManager.getTransaction().begin();
        Bill foundBill = entityManager.find(Bill.class, billNumber);

        entityManager.getTransaction().commit();
        entityManager.close();

        return foundBill;
    };
    public void save(Bill bill) {
        entityManager.getTransaction().begin();
        entityManager.persist(bill);
        entityManager.getTransaction().commit();

    }

    /**
     *
     * @param bill на какой счет
     * @param summ сколько
     * @param znak true + плюсонуть   , false - отнять
     */
    public void update(Bill bill, BigDecimal summ, boolean znak) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Bill SET "+
         "balance=:bal, client=:client WHERE billNumber=:number");

        query.setParameter("number",bill.getBillNumber());
        query.setParameter("client",bill.getClient());
        if(znak) query.setParameter("bal",bill.getBalance().add(summ));
        if(!znak) query.setParameter("bal",bill.getBalance().subtract(summ));

        query.executeUpdate();
        entityManager.getTransaction().commit();

    }


}
