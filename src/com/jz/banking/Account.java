package com.jz.banking;

public abstract class Account extends BaseAccount implements Interest {
    Account(double amount) {
        super(amount);
    }
}
