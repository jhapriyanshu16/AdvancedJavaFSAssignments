package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class App {

    public static void main(String[] args) {

        PersistenceUnitInfo pui = new CustomPersistenceUnitInfo();

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, pui.getProperties());

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new Person(
                "Priyanshu",
                "Jha",
                "priyanshu76@gmail.com",
                22
        );

        em.persist(p);

        em.getTransaction().commit();

        System.out.println("✅ Inserted: " + p);

        em.close();
        emf.close();
    }
}