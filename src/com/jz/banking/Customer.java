package com.jz.banking;

import java.util.LinkedList;

public class Customer extends Person implements Messaging {

    private LinkedList<BaseAccount> accountList = new LinkedList<>();

    public Customer(String firstName, String lastName) {

        setFirstName(firstName).setLastName(lastName);
    }
    public void addAccount(BaseAccount acc) {
        accountList.add(acc);
    }
    public boolean removeAccount(BaseAccount acc) {
        return accountList.remove(acc);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        for(BaseAccount acc: accountList) {
            System.out.print("   ");
            acc.showInfo();
            //acc.showOperations();
        }
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("[" + getfirstName() + " " + getlastName() + "]:  " + message);
    }

}