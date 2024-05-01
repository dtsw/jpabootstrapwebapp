package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args)  {
        // Press Alt+Eingabe with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Umschalt+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Umschalt+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Strg+F8.
            System.out.println("i = " + i);
        }

        Product product = new Product();
        product.setName("Toast");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderManagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        System.out.println(product.getId());
        Long id = product.getId();
        Product a = entityManager.find(Product.class, id);

        if ( null != a ) {
            System.out.println(a.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}