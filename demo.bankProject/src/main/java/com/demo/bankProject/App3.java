package com.demo.bankProject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Cust Id To Update the Data: ");
        int id = scan.nextInt();

		        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		        Session session = factory.openSession();     
		        Transaction transaction = session.beginTransaction();
		        Customer customer = session.get(Customer.class, id);
		        if (customer != null) {
		        	System.out.println("Exitsing Data");
		        	System.out.println(customer.getName()+" "+customer.getAddress()+" "+ customer.getAddress()+" "+customer.getEmail()+" "+customer.getPhone());
		        	System.out.println("Chhose attribute to update");
		        	System.out.println("name |  address | email | phone ");
		        	String ua = scan.next();
		        		
		        	switch(ua) {
		        		case "name" :System.out.println("Enter New Name");
		        		String newName = scan.next();
		        		customer.setName(newName);
		        		break;
		        		case "address" :System.out.println("Enter New Address");
		        		String newAddress = scan.next();
		        		customer.setAddress(newAddress);
		        		break;
		        		case "email" :System.out.println("Enter New Email");
		        		String newEmail = scan.next();
		        		customer.setEmail(newEmail);
		        		break;
		        		case "phone" :System.out.println("Enter New Phone No");
		        		String newPhone = scan.next();
		        		customer.setPhone(newPhone);
		        		break;
		        		default: System.out.println("NO PROPER ATTRIBUTE SELECTED HENCE TO CHANGE OCCURED: ");
		        	}
		        		customer= session.merge(customer);
		        		 transaction.commit();
		        		 System.out.println(customer);
		 		         session.close();
		 		         factory.close();
		        
		           
		        } else {
		            System.out.println("User Does Not Exit to Update");
		        }
		        
		        }

	
		    }
		
		
	


