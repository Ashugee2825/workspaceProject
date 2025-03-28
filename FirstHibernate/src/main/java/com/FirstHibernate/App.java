/**

package com.FirstHibernate;




import java.util.Scanner;

public class App {
    public static void main(String[] args) {
   
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter ID , Name, Marks , Email");
    	
    	Student student = new  Student(scan.nextInt(),scan.next(),scan.next(),scan.next());
    	
    	
    	//step -1 loading the configuration 
    	
      confiuration 
    	
    	//Step2 build session factory
    	
    	SesionFactory = confi
    	
    	
    	// step 3 
    	Session session = factory.openSession();
    	// step 4 r
    	
    	Transcation transaction = session.beginTransaction();
    	//step5 performing operation store the object
    	
    	session.save(student);
    	
    	// step 6 commit the trans
    	transcation.commit();
    	
    	session.close();
    	
    	factory.close();
    	
    }
}


*/


package com.FirstHibernate;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Step 1: Initialize Scanner to accept input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ID, Name, Marks, Email:");

        // Step 2: Create Student object with user input
        Student student = new Student();
        student.setId(scan.nextInt());
        scan.nextLine(); // Consume the remaining newline
        student.setName(scan.nextLine());
        student.setMarks(scan.nextLine());
        student.setEmail(scan.nextLine());

        // Step 3: Load configuration and build SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Ensure this file exists and is correctly configured
        configuration.addAnnotatedClass(Student.class);

        SessionFactory factory = configuration.buildSessionFactory();

        // Step 4: Open a session and begin a transaction
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Step 5: Save the Student object
            session.save(student);

            // Step 6: Commit the transaction
            transaction.commit();
            System.out.println("Student saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction on error
            }
            e.printStackTrace();
        } finally {
            // Step 7: Close the session and factory
            factory.close();
        }

        scan.close(); // Close the Scanner
    }
}
