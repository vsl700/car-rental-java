package com.vsl700.carrental.models;

public class Customer {
    private String firstName;
    private String lastName;
    private int age;
    private int driverExperience;

    public Customer(String firstName, String lastName, int age, int driverExperience) {
        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's experience cannot be negative!");

        if(age < 0)
            throw new IllegalArgumentException("Customer's age cannot be negative!");

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.driverExperience = driverExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0)
            throw new IllegalArgumentException("Customer's age cannot be negative!");

        this.age = age;
    }

    public int getDriverExperience() {
        return driverExperience;
    }

    public void setDriverExperience(int driverExperience) {
        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's experience cannot be negative!");

        this.driverExperience = driverExperience;
    }
}
