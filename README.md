# Car Rental - Java
This is a console application that can calculate rents and insurances for several kinds of vehicles (car, cargovan and motorcycle) 
based on their value, rental period, rental & return dates and others (depending on the type of vehicle). This project was written
as a solution to the Java & React Internship 2024 assignment at Prime Holding JSC.

## Solution
The application has two services - an `InvoiceCalculator` and an `InvoicePrinter`. The `InvoiceCalculator` calculates an invoice
based on a given return date and returns an Invoice class containing the calculated invoice values. The `InvoicePrinter` simply 
prints an already generated Invoice to the console. This approach is convenient if the user wants to print an old invoice that
was, for example, saved in a database.

An Invoice is being generated based on a rented vehicle and the vehicle's return date. The vehicle is represented by a Vehicle
class that contains a brand, model, value (price), rental period (in days), return date and the vehicle's customer. The Invoice
class contains a reference to the rented vehicle, date of return, daily rental cost, initial daily insurance cost, daily insurance
discount and early return discounts for rent and insurance.

The logic of the application is tested inside the Main class! Below you can see screenshots of the results.

## Screenshots
![image](https://github.com/vsl700/car-rental-java/assets/51147745/7c598ad1-f5a6-480f-9a35-e1ffe72c600e)

![image](https://github.com/vsl700/car-rental-java/assets/51147745/56979e91-45e1-4447-bfcd-688d44389ed2)

![image](https://github.com/vsl700/car-rental-java/assets/51147745/adce21d4-4ea5-4644-be0a-bcbea2401a31)

