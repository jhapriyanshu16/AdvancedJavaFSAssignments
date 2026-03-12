package com.example.looseCoupling;


import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailNotificationService implements NotificationService{
    public void send(String message){
        System.out.println("Sending Email Notification");
        System.out.println("{ message: "+ message + " }");
    }
}
