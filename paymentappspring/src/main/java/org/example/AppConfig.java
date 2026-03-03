package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {
        return new CreditCardPayment();
    }

    @Bean
    public CheckoutService checkoutService() {
        return new CheckoutService(paymentService());
    }
}