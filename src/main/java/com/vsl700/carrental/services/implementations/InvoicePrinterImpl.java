package com.vsl700.carrental.services.implementations;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import com.vsl700.carrental.models.Invoice;
import com.vsl700.carrental.services.InvoicePrinter;

public class InvoicePrinterImpl implements InvoicePrinter {
    @Override
    public void print(Invoice invoice) {
        Date now = Date.from(Instant.now());
        long actualRentalDays = ChronoUnit.DAYS.between(invoice.getVehicle().getRentedOn().toInstant(), invoice.getReturnDate().toInstant());
        
        Locale locale = Locale.US;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println("XXXXXXXXXX");

        // General invoice information
        System.out.println("Date: %s".formatted(now));
        System.out.println("Customer Name: %s %s"
            .formatted(invoice.getVehicle().getCustomer().getFirstName(), invoice.getVehicle().getCustomer().getLastName()));
        System.out.println("Rented Vehicle: %s %s"
            .formatted(invoice.getVehicle().getBrand(), invoice.getVehicle().getModel()));
        
        // Reservation information
        System.out.println("\nReservation start date: %s".formatted(invoice.getVehicle().getRentedOn()));
        Date reservationEndDate = Date.from(Instant.ofEpochMilli(invoice.getVehicle().getRentedOn().getTime()).plus(invoice.getVehicle().getRentalPeriod(), ChronoUnit.DAYS));
        System.out.println("Reservation end date: %s".formatted(reservationEndDate));
        System.out.println("Reserved rental days: %s days".formatted(invoice.getVehicle().getRentalPeriod()));

        // Actual usage information
        System.out.println("\nActual Return date: %s".formatted(invoice.getReturnDate()));
        System.out.println("Actual rental days: %s days".formatted(actualRentalDays));

        // Costs per day (including insurance discounts)
        double dailyRent = invoice.getDailyRentalCost();
        System.out.println("\nRental cost per day: %s".formatted(currencyFormatter.format(dailyRent)));
        double actualDailyInsurance = invoice.getInitialDailyInsurance() - invoice.getDailyInsuranceDiscount();
        if(invoice.getInitialDailyInsurance() != actualDailyInsurance){ // If there is insurance discount
            System.out.println("Initial insurance per day: %s".formatted(currencyFormatter.format(invoice.getInitialDailyInsurance())));
            double dailyInsuranceDiscount = invoice.getDailyInsuranceDiscount();
            if(dailyInsuranceDiscount < 0)
                System.out.println("Insurance addition per day: %s".formatted(currencyFormatter.format(-dailyInsuranceDiscount)));
            else if(dailyInsuranceDiscount > 0)
                System.out.println("Insurance discount per day: %s".formatted(currencyFormatter.format(dailyInsuranceDiscount)));
        }
        System.out.println("Insurance per day: %s".formatted(currencyFormatter.format(actualDailyInsurance)));
        
        // Early return discounts
        double earlyRentDiscount = invoice.getEarlyRentDiscount();
        if(earlyRentDiscount != 0)
            System.out.println("\nEarly return discount for rent: %s".formatted(currencyFormatter.format(earlyRentDiscount)));
        double earlyInsuranceDiscount = invoice.getEarlyInsuranceDiscount();
        if(earlyInsuranceDiscount != 0)
            System.out.println("Early return discount for insurance: %s".formatted(currencyFormatter.format(earlyInsuranceDiscount)));

        // Total costs
        double totalRent = dailyRent * invoice.getVehicle().getRentalPeriod() - earlyRentDiscount;
        double totalInsurance = actualDailyInsurance * invoice.getVehicle().getRentalPeriod() - earlyInsuranceDiscount;
        double total = totalRent + totalInsurance;
        System.out.println("\nTotal rent: %s".formatted(currencyFormatter.format(totalRent)));
        System.out.println("Total insurance: %s".formatted(currencyFormatter.format(totalInsurance)));
        System.out.println("Total: %s".formatted(currencyFormatter.format(total)));

        System.out.println("XXXXXXXXXX");
    }
}
