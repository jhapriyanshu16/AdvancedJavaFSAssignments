package paymentsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CheckoutService checkoutService = context.getBean(CheckoutService.class);

        checkoutService.makePayment(20000);
    }
}
