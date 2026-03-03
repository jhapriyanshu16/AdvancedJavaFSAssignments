package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ReportController controller = context.getBean(ReportController.class);

        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 to generate PDF Report");
        System.out.println("Press 2 to generate Excel Report");

        int choice = sc.nextInt();

        controller.generate(choice);
    }
}