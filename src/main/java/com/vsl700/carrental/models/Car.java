package com.vsl700.carrental.models;

import java.util.Date;

public class Car extends Vehicle {
    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 5;

    private int rating;

    public Car(Date rentedOn, Customer customer, String brand, String model, float value, int rentalPeriod, int rating) {
        super(rentedOn, customer, brand, model, value, rentalPeriod);

        if(rating < MIN_RATING || rating > MAX_RATING)
            throw new IllegalArgumentException("Rating should be between 1 and 5!");

        this.rating = rating;
    }

    /** Car's rating (1-5) */
    public int getRating() {
        return rating;
    }

    /** Sets the car's rating (1-5) */
    public void setRating(int rating) {
        if(rating < MIN_RATING || rating > MAX_RATING)
            throw new IllegalArgumentException("Rating should be between 1 and 5!");

        this.rating = rating;
    }
}
