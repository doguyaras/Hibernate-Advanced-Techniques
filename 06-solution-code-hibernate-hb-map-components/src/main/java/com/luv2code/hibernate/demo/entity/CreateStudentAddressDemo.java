package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;

public class CreateStudentAddressDemo {

    public static void main(String[] args) {

        // create seession factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        // create session
        try (factory; Session session = factory.getCurrentSession()) {
            // create the student object
            Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

            // create the address object
            Address billingAddress = new Address("Some billing Street", "Some Billing City", "101010");


            // start a transaction
            session.beginTransaction();

            // save the object
            System.out.println("Saving the student and address..");
            tempStudent.setBillingAddress(billingAddress);
            session.persist(tempStudent);

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        // clean up code


    }
}
