package com.jz.banking;

public class StudentAccount extends Account {

    public StudentAccount(double amount) {
        super(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + 1);
    }

    @Override
    public boolean transferTo(BaseAccount acc, double amount) {

        if(super.withdraw(amount + 2))
            return acc.deposit(amount);
        return false;
    }

    @Override
    public double capitalize() {
        double amount = getBalance()*0.1;
        deposit(amount);
        return amount;
    }
    public void showInfo() {
        System.out.println("Konto student nr" + getNumber() + ". Saldo: " + getBalance());
    }
}