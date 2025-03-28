package com.demo.bankProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Cust Id To Delete");
		        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		        Session session = factory.openSession();     
		   Transaction transaction = session.beginTransaction();
		   int id = scan.nextInt();
		        Customer customer = session.get(Customer.class, id);
		        if (customer != null) {
		           session.remove(customer);
		        } else {
		            System.out.println("User Does Not Exit to Delete");
		        }

		        transaction.commit();
		        session.close();
		        factory.close();
		    }
		
		
	}


