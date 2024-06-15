package com.vsl700.carrental.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Vehicle {
    /** Vehicle's brand */
    private String brand;
    /** Vehicle's model */
    private String model;
    /** Vehicle's price */
    private float value;
    /** Vehicle's rental period in days */
    private int rentalPeriod;

    /** The date this vehicle was rented on */
    private Date rentedOn;

    /** The customer renting the vehicle */
    private Customer customer;
}
