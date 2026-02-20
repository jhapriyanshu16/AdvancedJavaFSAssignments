package org.lpu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lpu.entity.User;
import org.lpu.entity.Address;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class App {

    public static void main(String[] args) throws IOException {


        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();


        Session session = factory.openSession();

        try {
            session.beginTransaction();

            User user = new User("Priyanshu", "p@gmail.com");

            File img = new File("sample.jpg");
            FileInputStream f = new FileInputStream(img);
            byte[] imageBytes = new byte[f.available()];
            f.close();

            Address a1 = new Address("Delhi", "Delhi", "India", new Date(), user, imageBytes);
            Address a2 = new Address("Patna", "Bihar", "India", new Date(), user, imageBytes);


            user.setAddresses(Arrays.asList(a1, a2));

            session.persist(user);

            session.getTransaction().commit();

            System.out.println("User, addresses, and images saved successfully!");

        } finally {
            session.close();
            factory.close();
        }
    }
}