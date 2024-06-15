package com.vsl700.carrental.models;

public class Car extends Vehicle {
    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 5;

    private int rating;

    public Car(String brand, String model, float value, int rentalPeriod, int rating) {
        super(brand, model, value, rentalPeriod);

        if(rating < MIN_RATING || rating > MAX_RATING)
            throw new IllegalArgumentException("Rating should be between 1 and 5!");

        this.rating = rating;
    }

    /** Car's rating (1-5) */
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating < MIN_RATING || rating > MAX_RATING)
            throw new IllegalArgumentException("Rating should be between 1 and 5!");

        this.rating = rating;
    }
}
