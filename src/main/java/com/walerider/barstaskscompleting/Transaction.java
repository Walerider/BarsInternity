package com.walerider.barstaskscompleting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Long accountId;
    private Long amount;
    private Date transactionDate;

    public Transaction() {
    }
    //конструктор для preload
    public Transaction(Long id, Long accountId, Long amount, Date transactionDate) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Transaction(Long accountId, Long amount, Date transactionDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
