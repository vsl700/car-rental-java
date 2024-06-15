package com.vsl700.carrental.models;

public class Motorcycle extends Vehicle {
    private int riderAge;

    public Motorcycle(String brand, String model, float value, int rentalPeriod, int riderAge) {
        super(brand, model, value, rentalPeriod);

        if(riderAge < 0)
            throw new IllegalArgumentException("Rider age should not be negative!");

        this.riderAge = riderAge;
    }

    /** Motorcycle's rider's age */
    public int getRiderAge() {
        return riderAge;
    }

    public void setRiderAge(int riderAge) {
        if(riderAge < 0)
            throw new IllegalArgumentException("Rider age should not be negative!");

        this.riderAge = riderAge;
    }
}
