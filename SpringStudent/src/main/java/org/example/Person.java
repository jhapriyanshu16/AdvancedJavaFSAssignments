package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Priyanshu";
    private int age = 22;

    @Autowired   // dependency injection
    private Mobile mobile;

    public void displayPerson() {
        System.out.println("Name: " + name + ", Age: " + age);
        mobile.displayMobile();
    }
}