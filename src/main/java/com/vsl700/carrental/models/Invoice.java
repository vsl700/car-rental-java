package com.vsl700.carrental.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Invoice {
    private Vehicle vehicle;
    private Date returnDate;
    private float dailyRentalCost;
    private float initialDailyInsurance;
    private float dailyInsuranceDiscount;
    private float rentForRemainingDays;
    private float earlyInsuranceDiscount;
}
