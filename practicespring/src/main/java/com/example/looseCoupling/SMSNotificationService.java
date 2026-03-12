package com.example.looseCoupling;


import org.springframework.stereotype.Component;

@Component("smsService")
public class SMSNotificationService implements NotificationService{
    public void send(String message){
        System.out.println("Sending SMS Notification");
        System.out.println("{ message: "+ message + " }");
    }
}
