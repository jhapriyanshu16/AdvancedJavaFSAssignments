package paymentsystem.services;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentService {
    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" rupees through CreditCard");
    }
}
