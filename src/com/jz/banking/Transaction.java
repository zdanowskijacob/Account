package com.jz.banking;

import java.time.*;

public class Transaction implements Info {

    public enum operationType {
        deposit,
        withdraw,
        transfer
    }

    private double amount;
    private operationType type;
    private LocalDateTime time;

    Transaction(double amount, operationType type) {
        this.amount = amount;
        this.type = type;
        time= LocalDateTime.now();

    }

    @Override
    public void showInfo() {
        System.out.println(time+ ": " + type +" ("+amount+")");
    }

}
