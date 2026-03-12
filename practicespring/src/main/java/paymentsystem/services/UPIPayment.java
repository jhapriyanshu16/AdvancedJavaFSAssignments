package paymentsystem.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class UPIPayment implements PaymentService {
    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" rupees through UPI");
    }
}
