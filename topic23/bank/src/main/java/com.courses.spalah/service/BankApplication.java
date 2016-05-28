package com.courses.spalah.service;

import com.courses.spalah.dao.BillDAO;
import com.courses.spalah.dao.ClientDAO;
import com.courses.spalah.dao.TransactionDAO;
import com.courses.spalah.dao.impl.BillDaoImpl;
import com.courses.spalah.dao.impl.ClientDaoImpl;
import com.courses.spalah.dao.impl.TransactionDaoImpl;
import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;
import com.courses.spalah.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class BankApplication {
    private static final String PERSISTENCE_UNIT = "com.courses.spalah.bank";
    protected EntityManager entityManager;
    private BillDAO billDao;
    private ClientDAO clientDao;
    private TransactionDAO transactionDao;


    private   void close() {
        if (entityManager.isOpen()) entityManager.close();
    }


    public   Client addClient(String firstName, String lastName, String inn) {

        checkEntity();

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setInn(Long.parseLong(inn));


        clientDao.save(client);
        entityManager.close();
        System.out.println(client.toString()+" Успешно добавлен");
        return client;
    }
    public   Client findClient(Long inn)
    {
        checkEntity();
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(inn);
        return client;
    }
    public   void addBill(Client client, BigDecimal ballance) {
        checkEntity();
        BillDaoImpl billDao = new BillDaoImpl(entityManager);

        Bill bill = new Bill();
        bill.setBalance(ballance);
        bill.setClient(client);
        billDao.save(bill);
        if (entityManager.isOpen()) entityManager.close();
    }

    public   List<Bill> getAllBill(Client client) {
        checkEntity();
        BillDaoImpl billDao = new BillDaoImpl(entityManager);
        Collection<Bill> list = billDao.getBillsByClient(client);

        if (entityManager.isOpen()) entityManager.close();
        return (List<Bill>) list;
    }

    public   List<Client> getAllClients() {
        checkEntity();
        List<Client> allClients = clientDao.getAllClient();
        for (Client cl : allClients) {
            System.out.println(cl.toString());
        }
        if (entityManager.isOpen()) entityManager.close();
        return allClients;
    }

    //Если бабки пойдут в другой банк
    public   void makeTransaction(Bill bill, BigDecimal summ) {
        checkEntity();
        TransactionDaoImpl trDAO = new TransactionDaoImpl(entityManager);
        Transaction transaction = new Transaction();
        transaction.setBill(bill);
        transaction.setSummTransaction(summ);
        transaction.setTransactionTime(new Date());
        trDAO.save(transaction);
        if (entityManager.isOpen()) entityManager.close();

    }

    public   void makeTransaction(Bill sender, Bill recipient, BigDecimal summ) {
        checkEntity();
        if (isTransactionValid(sender, recipient, summ)) {
            //попробовать сделать единой транзакцией

            BillDaoImpl billDao = new BillDaoImpl(entityManager);
            billDao.update(sender, summ, false); // минус данная сумма
            billDao.update(recipient, summ, true);// плюс данная сумма

            makeTransaction(sender, summ);
            makeTransaction(recipient, summ);

        }

        if (entityManager.isOpen()) entityManager.close();
    }

    public   List<Transaction> getAllTrasactions() {
        checkEntity();
        TransactionDaoImpl transactionDao = new TransactionDaoImpl(entityManager);
        List<Transaction> transactionList = transactionDao.getAllTransactions();
        entityManager.close();

        for (Transaction tr : transactionList) {
            System.out.println(tr.toString());
        }
        return transactionList;
    }

    public   List<Transaction> getAllTrasactions(Client client) {
        checkEntity();
        List<Bill> bills = getAllBill(client);
        List<Transaction> transactions = new ArrayList<Transaction>();

        for (Bill b : bills) {
            transactions.addAll(getAllTrasactions(b));
        }

        if (entityManager.isOpen()) entityManager.close();
        System.out.println("======== Все транзакции по клиенту================");
        System.out.println("Клиент " +client.getFirstName() + " " + client.getLastName() );
        for(Transaction t : transactions)
            System.out.println(t.toString());
        return transactions;
    }

    public   List<Transaction> getAllTrasactions(Bill bill) {
        checkEntity();
        TransactionDAO transactionDAO = new TransactionDaoImpl(entityManager);
        Collection<Transaction> list = transactionDAO.getTransactionsByBill(bill);

        if (entityManager.isOpen()) entityManager.close();
        return (List<Transaction>) list;
    }

    public   Bill getBillByNumber(Long number) {
        checkEntity();
        BillDaoImpl billDAO = new BillDaoImpl(entityManager);
        Bill bill = billDAO.findByNumber(number);
        if (entityManager.isOpen()) entityManager.close();
        return bill;
    }

    /**
     * Проверяет Возможность операции.
     * Какой допустимый кредит от банка по конкретному ссчету
     */
    private   boolean isTransactionValid(Bill sender, Bill recipient, BigDecimal summ) {
        return true;
    }


    private   static EntityManager initEntityManager() {
        //Хранить в класе гдето  ипроверять на нулл и если не нулл возвор
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
    private  void checkEntity()
    {
        if(entityManager == null || !entityManager.isOpen())
            entityManager = initEntityManager();

    }

    public void setBillDao(BillDAO billDao) {
        this.billDao = billDao;
    }

    public void setClientDao(ClientDAO clientDao) {
        this.clientDao = clientDao;
    }

    public void setTransactionDao(TransactionDAO transactionDao) {
        this.transactionDao = transactionDao;
    }
}

