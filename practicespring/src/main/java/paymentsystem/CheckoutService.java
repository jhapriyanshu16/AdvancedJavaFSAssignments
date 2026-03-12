package paymentsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import paymentsystem.services.PaymentService;

@Component
public class CheckoutService {
    private PaymentService paymentService;

    @Autowired
    public CheckoutService(@Qualifier("creditCardPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(int amount){
        System.out.println("Making payment. Please Wait...");
        paymentService.pay(amount);
    }
}
