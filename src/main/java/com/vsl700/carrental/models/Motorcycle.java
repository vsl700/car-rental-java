package com.vsl700.carrental.models;

import java.util.Date;

public class Motorcycle extends Vehicle {
    public Motorcycle(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod) {
        super(brand, model, value, rentalPeriod, rentedOn, customer);
    }
}
