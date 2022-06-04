package com.jz.banking;

import java.util.LinkedList;

public class Bank implements Info {

    private LinkedList<BaseAccount> accountList = new LinkedList<>();
    private LinkedList<Customer> customerList = new LinkedList<>();

    public void addCustomer(Customer cst) {
        customerList.add(cst);
    }

    boolean checkCustomer(Customer cst) {
        return customerList.indexOf(cst) >= 0;
    }

    boolean checkAccount(BaseAccount acc) {
        return accountList.indexOf(acc) >= 0;
    }

    public Customer findCustomer(String firstName, String lastName) {
        for (Customer cst : customerList) {
            if (cst.getfirstName().equalsIgnoreCase(firstName)
                    && cst.getlastName().equalsIgnoreCase(lastName)) {
                return cst;
            }
        }
        return null;
    }

    public BaseAccount findAccount(int number) {
        for (BaseAccount acc : accountList) {
            if (acc.getNumber() == number) {
                return acc;
            }
        }
        return null;
    }

    public BaseAccount createAccount(Customer cst, AccountType at) {

        if (!checkCustomer(cst)) {
            return null;
        }
        BaseAccount newAcc;
        switch (at) {
            case SENIOR:
                newAcc = new SeniorAccount(0);
                break;
            case STUDENT:
                newAcc = new StudentAccount(0);
                break;
            default:
                return null;
        }
        accountList.add(newAcc);
        cst.addAccount(newAcc);
        return newAcc;
    }

    @Override
    public void showInfo() {
        showAccounts();
        showCustomers();
    }

    public void showAccounts() {
        for (BaseAccount acc : accountList) {
            acc.showInfo();
        }
    }

    public void showCustomers() {
        for (Customer cst : customerList) {
            cst.showInfo();
        }
    }
}
