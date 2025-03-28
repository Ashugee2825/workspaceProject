//package com.demo.bankProject;
//
//import java.lang.module.Configuration;
//
//public class App {
//    public static void main(String[] args) {
//
//    //Configuration  configuration = new Configuration();
//    //configuration
//    	
//    	 Customer customer = new Customer(1,101,"Ashu","Patna","don@gmail.com","78945");
//    	SessionFactory factory = new Configuration().configure("");
//    	Session session = factory.openSession();
//    	Transaction transaction = session.beginTransaction();
//    	
//   	 tarnsaction.commit();
//   	 session.close();
//   	 factory.close();
//    	
//    
//    }
//}


package com.demo.bankProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create a Hibernate configuration object
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Specify the configuration file

        // Create a SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();

        // Create a Session
        Session session = factory.openSession();

        // Begin a Transaction
        Transaction transaction = session.beginTransaction();

        // Create a new Customer object
        Customer customer = new Customer(5, 105, "Chintu", "Banglore", "chin@gmail.com", "9477874");

        // Save the Customer object
        session.save(customer);

        // Commit the transaction
        transaction.commit();

        // Close the session and factory
        session.close();
        factory.close();

        System.out.println("Customer data inserted successfully!");
    }
}


