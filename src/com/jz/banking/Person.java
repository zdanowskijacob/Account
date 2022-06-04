package com.jz.banking;

public class Person implements Info {

    private String firstName;
    private String lastName;

    public Person setFirstName(String firstName) {
        this.firstName=firstName;
        return this;
    }
    public Person setLastName(String lastName) {
        this.lastName=lastName;
        return this;
    }
    String getfirstName() {
        return firstName;
    }
    String getlastName() {
        return lastName;
    }

    @Override
    public void showInfo() {
        System.out.println("Osoba: " + firstName + " " + lastName);
    }
}
