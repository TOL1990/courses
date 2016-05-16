import com.courses.spalah.dao.TransactionDAO;
import com.courses.spalah.dao.impl.BillDaoImpl;
import com.courses.spalah.dao.impl.ClientDaoImpl;
import com.courses.spalah.dao.impl.TransactionDaoImpl;
import com.courses.spalah.model.Bill;
import com.courses.spalah.model.Client;
import com.courses.spalah.model.Transaction;
import com.courses.spalah.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Leonid on 14.05.2016.
 */
public class BankApplication {
    private static final String PERSISTENCE_UNIT = "com.courses.spalah.bank";
    protected static EntityManager entityManager;

    public static void main(String[] args) {

        Client client = findClient(789654135L);
        getAllTrasactions(client);
////        test();
        try {
            close();
        } catch (Exception e) {
            System.out.println("Trables with closing entityManager. " + e.getMessage());
        }
        System.out.println("Hey Dude! App Close");

    }

    private static void close() {
        if (entityManager.isOpen()) entityManager.close();
    }


    private static Client addClient(Client clientouter) {

        entityManager = initEntityManager();
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);
        Client client = new Client();
        client.setFirstName("Jorik");
        client.setLastName("Vartanov");
        client.setInn(1236547895L);

//        clientDao.save(clientouter); // TODO: 15.05.2016  пихнуть когда будет UI
        clientDao.save(client);
        entityManager.close();
        return client;
    }
    private static Client findClient(Long inn)
    {
        entityManager = initEntityManager();
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);
        Client client = clientDao.findByInn(inn);
        return client;
    }
    private static void addBill(Client client, BigDecimal ballance) {
        entityManager = initEntityManager();
        BillDaoImpl billDao = new BillDaoImpl(entityManager);

        Bill bill = new Bill();
        bill.setBalance(ballance);
        bill.setClient(client);
        billDao.save(bill);
        if (entityManager.isOpen()) entityManager.close();
    }

    public static List<Bill> getAllBill(Client client) {
        entityManager = initEntityManager();
        BillDaoImpl billDao = new BillDaoImpl(entityManager);
        Collection<Bill> list = billDao.getBillsByClient(client);

        if (entityManager.isOpen()) entityManager.close();
        return (List<Bill>) list;
    }

    public static List<Client> getAllClients() {
        entityManager = initEntityManager();
        ClientDaoImpl clientDao = new ClientDaoImpl(entityManager);

        List<Client> allClients = clientDao.getAllClient();
        for (Client cl : allClients) {
            System.out.println(cl.toString());
        }
        if (entityManager.isOpen()) entityManager.close();
        return allClients;
    }

    //Если бабки пойдут в другой банк
    private static void makeTransaction(Bill bill, BigDecimal summ) {
        entityManager = initEntityManager();
        TransactionDaoImpl trDAO = new TransactionDaoImpl(entityManager);
        Transaction transaction = new Transaction();
        transaction.setBill(bill);
        transaction.setSummTransaction(summ);
        transaction.setTransactionTime(new Date());
        trDAO.save(transaction);
        if (entityManager.isOpen()) entityManager.close();

    }

    private static void makeTransaction(Bill sender, Bill recipient, BigDecimal summ) {
        entityManager = initEntityManager();
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

    public static List<Transaction> getAllTrasactions() {
        entityManager = initEntityManager();
        TransactionDaoImpl transactionDao = new TransactionDaoImpl(entityManager);
        List<Transaction> transactionList = transactionDao.getAllTransactions();
        entityManager.close();

        for (Transaction tr : transactionList) {
            System.out.println(tr.toString());
        }
        return transactionList;
    }

    public static List<Transaction> getAllTrasactions(Client client) {
        entityManager = initEntityManager();
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

    public static List<Transaction> getAllTrasactions(Bill bill) {
        entityManager = initEntityManager();
        TransactionDAO transactionDAO = new TransactionDaoImpl(entityManager);
        Collection<Transaction> list = transactionDAO.getTransactionsByBill(bill);

        if (entityManager.isOpen()) entityManager.close();
        return (List<Transaction>) list;
    }

    public static Bill getBillByNumber(Long number) {
        entityManager = initEntityManager();
        BillDaoImpl billDAO = new BillDaoImpl(entityManager);
        Bill bill = billDAO.findByNumber(number);
        if (entityManager.isOpen()) entityManager.close();
        return bill;
    }

    /**
     * Проверяет Возможность операции.
     * Какой допустимый кредит от банка по конкретному ссчету
     */
    private static boolean isTransactionValid(Bill sender, Bill recipient, BigDecimal summ) {
        return true;
    }


    private static EntityManager initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
}
