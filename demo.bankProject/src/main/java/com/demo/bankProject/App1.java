//package com.demo.bankProject;
//
////import java.lang.module.Configuration;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import javax.print.attribute.standard.Compression;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//public class App1 {
//
//	public static void main(String[] args) {
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
//		transaction.commit();
//    	
//    	//session.get(Customer.class, 3);
//    	 Customer ref = session.get(Customer.class, 3);
//    	 System.out.println(ref.getid() + "" + ref.getAccno()+ ""+ refgetName()+" "+ ref.getAddress()+ " "+ref.getEmail()+ " "+ ref.getPhone());
//    	 tarnsaction.commit();
//    	 session.close();
//    	 factory.close();
//    	
//
	
//	}
//
//}



package com.demo.bankProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer ref = session.get(Customer.class, 3);
        if (ref != null) {
            System.out.println(ref.getId() + " " + ref.getAccno() + " " + ref.getName() + " " +
                    ref.getAddress() + " " + ref.getEmail() + " " + ref.getPhone());
        } else {
            System.out.println("Customer not found");
        }

        transaction.commit();
        session.close();
        factory.close();
    }
}

