package com.jz.banking;

public class SeniorAccount extends Account {

    private final static double WITHDRAW_COMM = 0.5;
    private final static double TRANSFER_COMM = 0.75;

    public SeniorAccount(double amount) {
        super(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + WITHDRAW_COMM);
    }

    @Override
    public boolean transferTo(BaseAccount acc, double amount) {

        if(super.withdraw(amount + TRANSFER_COMM))
            return acc.deposit(amount);
        return false;
    }
    @Override
    public double capitalize() {
        double amount = getBalance()*0.01;
        deposit(amount);
        return amount;
    }
    public void showInfo() {
        System.out.println("Konto senior nr" + getNumber() + ". Saldo: " + getBalance());
    }
}