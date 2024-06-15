package com.vsl700.carrental.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Invoice {
    private Vehicle vehicle;
    private Date returnDate;
    private double dailyRentalCost;
    private double initialDailyInsurance;
    private double dailyInsuranceDiscount;
    private double rentForRemainingDays;
    private double earlyInsuranceDiscount;
}
