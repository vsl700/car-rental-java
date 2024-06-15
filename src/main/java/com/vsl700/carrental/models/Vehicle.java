package com.vsl700.carrental.models;

import java.util.Date;

public abstract class Vehicle {
    private String brand;
    private String model;
    private float value;
    private int rentalPeriod;

    private Date rentedOn;

    private Customer customer;

    public Vehicle(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod) {
        this.rentedOn = rentedOn;
        this.customer = customer;
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.rentalPeriod = rentalPeriod;
    }

    /** The date this vehicle was rented on */
    public Date getRentedOn() {
        return rentedOn;
    }

    /** Sets the date this vehicle was rented on */
    public void setRentedOn(Date rentedOn) {
        this.rentedOn = rentedOn;
    }

    /** The customer renting the vehicle */
    public Customer getCustomer() {
        return customer;
    }

    /** Sets the customer renting the vehicle */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /** Vehicle's brand */
    public String getBrand() {
        return brand;
    }

    /** Sets the vehicle's brand */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** Vehicle's model */
    public String getModel() {
        return model;
    }

    /** Sets the vehicle's model */
    public void setModel(String model) {
        this.model = model;
    }

    /** Vehicle's price */
    public float getValue() {
        return value;
    }

    /** Sets the vehicle's price */
    public void setValue(float value) {
        this.value = value;
    }

    /** Vehicle's rental period in days */
    public int getRentalPeriod() {
        return rentalPeriod;
    }

    /** Sets the vehicle's rental period in days */
    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }
}
