package com.jz.banking;

import java.util.*;


public abstract class BaseAccount implements Operations, Info {

    private double balance;
    private final int number;
    private static int lastNumber = 100;


    LinkedList<Transaction> transactionList = new LinkedList<>();

    {
        number = generateNumber();
    }
    public BaseAccount() {
        balance = 0;

    }
    public BaseAccount(double amount) {
        if (amount < 0)
            amount = 0;
        balance = amount;
    }
    private static int generateNumber() {
        return ++lastNumber;
    }
    public final double getBalance() {
        return balance;
    }
    public final double getNumber() {
        return number;
    }
    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        balance += amount;
        transactionList.add(new Transaction(amount, Transaction.operationType.deposit));
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            return false;
        balance -= amount;
        transactionList.add(new Transaction(amount, Transaction.operationType.withdraw));
        return true;
    }
    public boolean transferTo(BaseAccount acc, double amount) {
        if (withdraw(amount)) {
            acc.deposit(amount);
            transactionList.add(new Transaction(amount, Transaction.operationType.transfer));
            return true;
        }
        return false;
    }
    public boolean transferTo(BaseAccount acc, double amount, double commission) {

        if (amount>0 && this.withdraw(amount + commission)) {
            acc.deposit(amount);
            return true;
        }
        return false;
    }

    public void showOperations() {

        for(Transaction tr : transactionList)
            tr.showInfo();
    }

    public abstract double capitalize();

    @Override
    public String toString() {
        return "[" + number + "]: " + balance;
    }
}