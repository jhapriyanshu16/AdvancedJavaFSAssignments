package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
        EntityManager enitityManager = entityManagerFactory.createEntityManager();
        Person p =  new Person("Priyaanshu","abc","6786898097");
        enitityManager.getTransaction().begin();

        enitityManager.persist(p);
        enitityManager.getTransaction().commit();
        enitityManager.close();
    }
}
