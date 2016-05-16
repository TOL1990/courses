package com.courses.spalah.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Leonid on 14.05.2016.
 */
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @Column(name = "bill_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "inn", nullable = true)
    private Client client;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "bill", orphanRemoval = true)
    private Collection<Transaction> transactions = new ArrayList<Transaction>();


    public Bill(){
        this.transactions = null;
    }

    public Bill(BigDecimal balance, Client client) {
        this.balance = balance;
        this.client = client;
    }

    public Bill(Long billNumber, BigDecimal balance, Client client) {
        this.billNumber = billNumber;
        this.balance = balance;
        this.client = client;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNumber=" + billNumber +
                ", balance=" + balance +
                ", client=" + client.toString() +
                '}';
    }
}
