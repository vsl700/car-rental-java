package com.vsl700.carrental.models;

import java.util.Date;

public class CargoVan extends Vehicle {
    private int driverExperience;

    public CargoVan(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod, int driverExperience) {
        super(rentedOn, customer, brand, model, value, rentalPeriod);

        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's expericence should not be negative!");

        this.driverExperience = driverExperience;
    }

    /** Cargo van's driver's experience in years */
    public int getDriverExperience() {
        return driverExperience;
    }

    /** Sets the cargo van's driver's experience in years */
    public void setDriverExperience(int driverExperience) {
        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's expericence should not be negative!");

        this.driverExperience = driverExperience;
    }
}
