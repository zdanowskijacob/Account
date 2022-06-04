package com.jz.banking;

public interface Operations {

    boolean withdraw(double amount);
    boolean deposit(double amount);
    boolean transferTo(BaseAccount acc, double amount);

}
