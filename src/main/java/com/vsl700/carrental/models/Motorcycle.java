package com.vsl700.carrental.models;

import java.util.Date;

public class Motorcycle extends Vehicle {
    private int riderAge;

    public Motorcycle(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod, int riderAge) {
        super(rentedOn, customer, brand, model, value, rentalPeriod);

        if(riderAge < 0)
            throw new IllegalArgumentException("Rider age should not be negative!");

        this.riderAge = riderAge;
    }

    /** Motorcycle's rider's age */
    public int getRiderAge() {
        return riderAge;
    }

    /** Sets the motorcycle's rider's age */
    public void setRiderAge(int riderAge) {
        if(riderAge < 0)
            throw new IllegalArgumentException("Rider age should not be negative!");

        this.riderAge = riderAge;
    }
}
