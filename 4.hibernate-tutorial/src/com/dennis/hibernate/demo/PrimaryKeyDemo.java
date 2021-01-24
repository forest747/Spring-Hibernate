package com.dennis.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.dennis.hibernate.demo.entity.Student;
public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session 
		Session session = factory.getCurrentSession();

		// use the session object to save the Java object
		
		try {	
			// create 3 student objects
			System.out.println("Creating new 3 student objects...");
			Student tempStudent1 = new Student("Doggy", "Kim", "idontknow@google.com");
			Student tempStudent2 = new Student("Pate", "Jo", "start@naver.com");
			Student tempStudent3 = new Student("Mike", "Apple", "winter@kakao.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
