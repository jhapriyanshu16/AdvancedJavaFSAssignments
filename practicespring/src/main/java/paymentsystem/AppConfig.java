package paymentsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import paymentsystem.services.CreditCardPayment;
import paymentsystem.services.PaymentService;
import paymentsystem.services.UPIPayment;

//@Configuration
//public class AppConfig {
//    @Bean
//    public PaymentService paymentService(){
//        return new CreditCardPayment();
//    }
//    @Bean
//    public CheckoutService checkoutService(PaymentService paymentService){
//        return new CheckoutService(paymentService);
//    }
//}

@Configuration
@ComponentScan("paymentsystem")
public class AppConfig{
//    @Bean
//    public CheckoutService checkoutService(@Qualifier("creditCardPayment") PaymentService paymentService){
//        return new CheckoutService(paymentService);
//    }
}
