package org.lpu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lpu.App;
import org.lpu.Product;

import java.util.List;

public class CRUD {

    public static void main(String[] args) {

        SessionFactory factory = App.getSessionFactory();
        Session session = factory.openSession();

        // create
        Transaction t = session.beginTransaction();

        Product product = new Product("Laptop", "HP Pavillion", "Electronics", 10, 75000.0, "No", true);
        Product product1 = new Product("Phone","smartphone","electronics",10,53333.0,"na",true);

        session.persist(product);
        session.persist(product1);
        t.commit();
        System.out.println("Product saved!");


        // Read
        t = session.beginTransaction();
        List<Product> products = session.createQuery("from Product", Product.class).list();

        for (Product p : products) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }

        t.commit();


        // Update
        t = session.beginTransaction();

        Product updateProduct = session.get(Product.class, 1L);
        updateProduct.setPrice(700000.0);

        t.commit();
        System.out.println("Product updated!");

        // Delete
        t = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 1L);
        session.remove(deleteProduct);

        t.commit();
        System.out.println("Product deleted!");


        session.close();
        factory.close();
    }
}
