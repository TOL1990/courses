package com.courses.spalah.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Leonid on 14.05.2016.
 */
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "transaction_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionNumber;

    @Column(name = "transaction_summ")
    private BigDecimal summTransaction;

    @Column(name = "transaction_date")
    private Date transactionTime;

    @ManyToOne
    @JoinColumn(name = "bill_number")
    private Bill bill;

    public Transaction() {
    }

    public Transaction(BigDecimal summTransaction, Date transactionTime, Bill bill) {
        this.summTransaction = summTransaction;
        this.transactionTime = transactionTime;
        this.bill = bill;
    }

    public Transaction(Long transactionNumber, BigDecimal summTransaction, Date transactionTime, Bill bill) {
        this.transactionNumber = transactionNumber;
        this.summTransaction = summTransaction;
        this.transactionTime = transactionTime;
        this.bill = bill;
    }

    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public BigDecimal getSummTransaction() {
        return summTransaction;
    }

    public void setSummTransaction(BigDecimal summTransaction) {
        this.summTransaction = summTransaction;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "# =" + transactionNumber +
                ", Summ =" + summTransaction +
                ", time =" + transactionTime +
                ", bill =" + bill +
                '}';
    }
}
