package com.courses.spalah.dao.impl;

import com.courses.spalah.dao.TransactionDAO;
import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Leonid on 15.05.2016.
 */
public class TransactionDaoImpl implements TransactionDAO {
    EntityManager entityManager;
    public TransactionDaoImpl(EntityManager entityManager) { this.entityManager = entityManager;
    }

    public void save(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }

    public List<Transaction> getAllTransactions() {
        entityManager.getTransaction().begin();
        List<Transaction> transactions = entityManager.createQuery("FROM Transaction", Transaction.class).getResultList();
        entityManager.getTransaction().commit();
        return transactions;
    }

    public List<Transaction> getTransactionsByBill(Bill bill) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("FROM Transaction WHERE bill.billNumber=:billNumb");
        query.setParameter("billNumb",bill.getBillNumber());

        List <Transaction> transactions = query.getResultList();
        entityManager.getTransaction().commit();
        return transactions;
    }

    public Transaction getTransactionByNumber(Long transactionNumber) {
        return null;
    }
}
