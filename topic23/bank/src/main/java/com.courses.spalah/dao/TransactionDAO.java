package com.courses.spalah.dao;

import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Leonid on 14.05.2016.
 */
public interface TransactionDAO extends Serializable {
    public void save(Transaction transaction);
    public List<Transaction> getAllTransactions();
    public List<Transaction> getTransactionsByBill (Bill bill);
    public Transaction getTransactionByNumber(Long transactionNumber);
}
