package com.vsl700.carrental.services.implementations;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.vsl700.carrental.models.Car;
import com.vsl700.carrental.models.CargoVan;
import com.vsl700.carrental.models.Invoice;
import com.vsl700.carrental.models.Motorcycle;
import com.vsl700.carrental.models.Vehicle;
import com.vsl700.carrental.services.InvoiceCalculator;

public class InvoiceCalculatorImpl implements InvoiceCalculator {
    @Override
    public Invoice generateInvoice(Vehicle returnedVehicle, Date returnDate) {
        var invoiceBuilder = Invoice.builder();
        invoiceBuilder.vehicle(returnedVehicle);
        invoiceBuilder.returnDate(returnDate);

        // Determining the type of the vehicle
        RentInsurancePrices rentInsurancePrices = null;
        if(returnedVehicle instanceof Car)
            rentInsurancePrices = RentInsurancePrices.CAR;
        else if(returnedVehicle instanceof Motorcycle)
            rentInsurancePrices = RentInsurancePrices.MOTORCYCLE;
        else if(returnedVehicle instanceof CargoVan)
            rentInsurancePrices = RentInsurancePrices.CARGOVAN;

        // Getting the respective price constants for the determined type of the vehicle
        double dailyRentalCost = rentInsurancePrices.dailyRentalCost(returnedVehicle);
        invoiceBuilder.dailyRentalCost(dailyRentalCost);
        double dailyInsuranceCost = rentInsurancePrices.dailyInsuranceCost(returnedVehicle);
        invoiceBuilder.initialDailyInsurance(dailyInsuranceCost);
        double insuranceDiscount = rentInsurancePrices.insuranceDiscount(returnedVehicle, dailyInsuranceCost);
        invoiceBuilder.dailyInsuranceDiscount(insuranceDiscount);

        // Checking for early discount
        long actualRentalDays = ChronoUnit.DAYS.between(returnedVehicle.getRentedOn().toInstant(), returnDate.toInstant());
        long remainingDays = returnedVehicle.getRentalPeriod() - actualRentalDays;
        if(remainingDays <= 0)
            return invoiceBuilder.build(); // No early discount

        // Calculating the early discount prices
        double discountedInsurance = dailyInsuranceCost - insuranceDiscount;
        double totalInsurance = discountedInsurance * returnedVehicle.getRentalPeriod();

        double rentForRemainingDays = dailyRentalCost / 2 * remainingDays;
        invoiceBuilder.rentForRemainingDays(rentForRemainingDays);
        double earlyInsuranceDiscount = totalInsurance - discountedInsurance * actualRentalDays;
        invoiceBuilder.earlyInsuranceDiscount(earlyInsuranceDiscount);

        return invoiceBuilder.build();
    }

    private enum RentInsurancePrices {
        CAR {
            @Override
            public double dailyRentalCost(Vehicle vehicle) {
                if(vehicle.getRentalPeriod() <= 7)
                    return 20; // A week or less

                return 15; // More than a week
            }

            @Override
            public double dailyInsuranceCost(Vehicle vehicle) {
                return vehicle.getValue() * 0.0001;
            }

            @Override
            public double insuranceDiscount(Vehicle vehicle, double dailyInsurance) {
                if(((Car) vehicle).getRating() >= 4)
                    return dailyInsurance * 0.1; // High rating

                return 0; // Low rating
            }
        },
        MOTORCYCLE {
            @Override
            public double dailyRentalCost(Vehicle vehicle) {
                if(vehicle.getRentalPeriod() <= 7)
                    return 15; // A week or less

                return 10; // More than a week
            }

            @Override
            public double dailyInsuranceCost(Vehicle vehicle) {
                return vehicle.getValue() * 0.0002;
            }

            @Override
            public double insuranceDiscount(Vehicle vehicle, double dailyInsurance) {
                if(vehicle.getCustomer().getAge() < 25)
                    return -dailyInsurance * 0.2; // Rider younger than 25

                return 0; // Rider 25 or older
            }
        },
        CARGOVAN {
            @Override
            public double dailyRentalCost(Vehicle vehicle) {
                if(vehicle.getRentalPeriod() <= 7)
                    return 50; // A week or less

                return 40; // More than a week
            }

            @Override
            public double dailyInsuranceCost(Vehicle vehicle) {
                return vehicle.getValue() * 0.0003;
            }

            @Override
            public double insuranceDiscount(Vehicle vehicle, double dailyInsurance) {
                if(vehicle.getCustomer().getDriverExperience() > 5)
                    return dailyInsurance * 0.15; // Driver with experience > 5 years

                return 0; // Driver with experience <= 5 years
            }
        };

        public abstract double dailyRentalCost(Vehicle vehicle);
        public abstract double dailyInsuranceCost(Vehicle vehicle);
        public abstract double insuranceDiscount(Vehicle vehicle, double dailyInsurance);
    }
}
