package com.vsl700.carrental.services;

import java.util.Date;

import com.vsl700.carrental.models.Invoice;
import com.vsl700.carrental.models.Vehicle;

public interface InvoiceCalculator {
    Invoice generateInvoice(Vehicle vehicle, Date returnDate);
}
