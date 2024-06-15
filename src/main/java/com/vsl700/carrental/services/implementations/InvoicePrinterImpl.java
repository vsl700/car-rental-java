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
        long remainingDays = ChronoUnit.DAYS.between(invoice.getVehicle().getRentedOn().toInstant(), invoice.getReturnDate().toInstant());

        Locale locale = Locale.US;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println("XXXXXXXXXX");
        System.out.println("Date: %s".formatted(now));
        System.out.println("Customer Name: %s %s"
            .formatted(invoice.getVehicle().getCustomer().getFirstName(), invoice.getVehicle().getCustomer().getLastName()));
        System.out.println("Rented invoice.getVehicle(): %s %s"
            .formatted(invoice.getVehicle().getBrand(), invoice.getVehicle().getModel()));
        
        System.out.println("\nReservation start date: %s".formatted(invoice.getVehicle().getRentedOn()));
        Date reservationEndDate = Date.from(Instant.ofEpochSecond(invoice.getVehicle().getRentedOn().getTime()).plus(invoice.getVehicle().getRentalPeriod(), ChronoUnit.DAYS));
        System.out.println("Reservation end date: %s".formatted(reservationEndDate));
        System.out.println("Reserved rental days: %s".formatted(invoice.getVehicle().getRentalPeriod()));

        System.out.println("\nActual return date: %s".formatted(invoice.getReturnDate()));
        System.out.println("Actual rental days: %s".formatted(remainingDays));

        float discountedDailyInsurance = invoice.getInitialDailyInsurance() - invoice.getDailyInsuranceDiscount(); // Not early discount!
        System.out.println("\nRental cost per day: %s".formatted(currencyFormatter.format(invoice.getDailyRentalCost())));
        System.out.println("Initial insurance per day: %s".formatted(currencyFormatter.format(invoice.getInitialDailyInsurance())));
        System.out.println("Insurance discount per day: %s".formatted(currencyFormatter.format(invoice.getDailyInsuranceDiscount())));
        System.out.println("Insurance per day: %s".formatted(currencyFormatter.format(discountedDailyInsurance)));
        
        System.out.println("\nEarly return discount for rent: %s".formatted(currencyFormatter.format(invoice.getRentForRemainingDays())));
        System.out.println("Early return discount for insurance: %s".formatted(currencyFormatter.format(invoice.getEarlyInsuranceDiscount())));

        float totalRent = invoice.getDailyRentalCost() * remainingDays + invoice.getRentForRemainingDays();
        float totalInsurance = discountedDailyInsurance - invoice.getEarlyInsuranceDiscount();
        System.out.println("\nTotal rent: $%s".formatted(currencyFormatter.format(totalRent)));
        System.out.println("Total Insurance: $%s".formatted(currencyFormatter.format(totalInsurance)));
        System.out.println("Total: %s".formatted(currencyFormatter.format(totalRent + totalInsurance)));

        System.out.println("XXXXXXXXXX");
    }
}
