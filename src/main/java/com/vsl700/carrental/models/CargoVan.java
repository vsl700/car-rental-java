package com.vsl700.carrental.models;

public class CargoVan extends Vehicle {
    private int driverExperience;

    public CargoVan(String brand, String model, float value, int rentalPeriod, int driverExperience) {
        super(brand, model, value, rentalPeriod);

        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's expericence should not be negative!");

        this.driverExperience = driverExperience;
    }

    /** Cargo van's driver's experience in years */
    public int getDriverExperience() {
        return driverExperience;
    }

    public void setDriverExperience(int driverExperience) {
        if(driverExperience < 0)
            throw new IllegalArgumentException("Driver's expericence should not be negative!");

        this.driverExperience = driverExperience;
    }
}
