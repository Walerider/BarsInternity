package com.walerider.barstaskscompleting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Long clientId;
    //Чё такое accountNumber? К чему он мне
    private Long accountNumber;
    private Long balance;

    public Account() {
    }
    //конструктор для preload
    public Account(Long id, Long clientId, Long accountNumber, Long balance) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(Long clientId, Long accountNumber, Long balance) {
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
