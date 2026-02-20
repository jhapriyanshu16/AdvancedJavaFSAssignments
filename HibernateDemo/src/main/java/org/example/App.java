package org.example;


import org.example.Student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // create configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);

        // create session factory
        SessionFactory factory = cfg.buildSessionFactory();

        // create session
        Session session = factory.openSession();

        // create student object
//        Student s1 = new Student("Nikhil", "Bihar");
        Student s1 = new Student("Kohli", "Delhi");
        // transaction start
        Transaction tx = session.beginTransaction();

        // save object
        session.save(s1);

//        fetch all
        List<Student> list = session.createQuery("from Student", Student.class).list();
        for(Student s : list){
            System.out.println(s.getId()+" "+s.getName()+" "+s.getCity());
        }

//      Updation
//        Student st = session.get(Student.class,1);
//        if(st!=null){
//            st.setCity("Delhi");
//        }

//      Delete
//        Student d = session.get(Student.class,5);
//        if(d!=null){
//            session.delete(d);
//        }


        // commit
        tx.commit();

        // close
        session.close();
        factory.close();

        System.out.println("Data inserted successfully!");
    }
}
