package org.example;

public class CheckoutService {

    private PaymentService paymentService;

    public CheckoutService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void checkout(double amount) {
        paymentService.pay(amount);
    }
}