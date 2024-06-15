package com.vsl700.carrental.models;

public abstract class Vehicle {
    private String brand;
    private String model;
    private float value;
    private int rentalPeriod;

    public Vehicle(String brand, String model, float value, int rentalPeriod) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.rentalPeriod = rentalPeriod;
    }

    /** Vehicle's brand */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** Vehicle's model */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /** Vehicle's price */
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    /** Vehicle's rental period in days */
    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }
}
