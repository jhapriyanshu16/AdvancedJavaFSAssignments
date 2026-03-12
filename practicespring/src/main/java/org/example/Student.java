package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("Priyanshu")
    String fname;
    @Value("Jha")
    String lname;
    @Value("22")
    int age;

    Address address;

    @Autowired
    public Student(Address address) {
        this.address = address;
    }

//    public Student(String fname, String lname, int age, Address address) {
//        this.fname = fname;
//        this.lname = lname;
//        this.age = age;
//        this.address = address;
//    }

    public void printStudentDetails(){
        System.out.println("Printing student details...");
        System.out.println(fname+ " "+ lname+ " is from : ");
        address.printAddressDetails();
    }

}
