package org.example;

public class UPIPayment implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}