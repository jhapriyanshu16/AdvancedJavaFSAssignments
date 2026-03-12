package org.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("Patna")
    String city;
    @Value("India")
    String country;
    @Value("847408")
    long pincode;

//    public Address(String city, String country, long pincode) {
//        this.city = city;
//        this.country = country;
//        this.pincode = pincode;
//    }

    public void printAddressDetails(){
        System.out.println("Printing address details...");
        System.out.println(city + " "+ country);

    }


}
