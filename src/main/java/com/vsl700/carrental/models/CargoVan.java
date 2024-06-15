package com.vsl700.carrental.models;

import java.util.Date;

public class CargoVan extends Vehicle {
    public CargoVan(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod) {
        super(brand, model, value, rentalPeriod, rentedOn, customer);
    }
}
