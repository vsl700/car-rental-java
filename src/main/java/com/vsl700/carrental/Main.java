package com.vsl700.carrental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.TimeZone;

import com.vsl700.carrental.models.Car;
import com.vsl700.carrental.models.CargoVan;
import com.vsl700.carrental.models.Customer;
import com.vsl700.carrental.models.Motorcycle;
import com.vsl700.carrental.services.InvoiceCalculator;
import com.vsl700.carrental.services.InvoicePrinter;
import com.vsl700.carrental.services.implementations.InvoiceCalculatorImpl;
import com.vsl700.carrental.services.implementations.InvoicePrinterImpl;

public class Main {
    private static final InvoiceCalculator invoiceCalculator = new InvoiceCalculatorImpl();
    private static final InvoicePrinter invoicePrinter = new InvoicePrinterImpl();

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        var customer1 = new Customer("John", "Doe", 30, 2);
        var car = new Car(formatter.parse("03-06-2024"), customer1, "Mitsubishi", "Mirage", 15000, 10, 3);
        var invoice1 = invoiceCalculator.generateInvoice(car, formatter.parse("13-06-2024"));
        invoicePrinter.print(invoice1);

        var customer2 = new Customer("Mary", "Johnson", 20, 1);
        var motorcycle = new Motorcycle(formatter.parse("03-06-2024"), customer2, "Triumph", "Tiger Sport 660", 10000, 10);
        var invoice2 = invoiceCalculator.generateInvoice(motorcycle, formatter.parse("13-06-2024"));
        invoicePrinter.print(invoice2);

        var customer3 = new Customer("John", "Markson", 25, 8);
        var cargovan = new CargoVan(formatter.parse("03-06-2024"), customer3, "Citroen", "Jumper", 20000, 15);
        var invoice3 = invoiceCalculator.generateInvoice(cargovan, formatter.parse("13-06-2024"));
        invoicePrinter.print(invoice3);
    }
}
