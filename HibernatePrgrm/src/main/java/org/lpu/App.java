package org.lpu;

import org.lpu.entity.Person;
import org.lpu.entity.Aadhaar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        Person p = new Person("Priyanshu", new Aadhaar("123456789012"));
        session.persist(p);

        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("Person saved successfully!");
    }
}
