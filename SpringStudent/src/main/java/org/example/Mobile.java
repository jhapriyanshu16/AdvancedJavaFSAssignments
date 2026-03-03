package org.example;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class Mobile {

    private String brand = "Apple";
    private int price = 80000;

    public void displayMobile() {
        System.out.println("Brand: " + brand + ", Price: " + price);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Mobile Initialized");
    }
}