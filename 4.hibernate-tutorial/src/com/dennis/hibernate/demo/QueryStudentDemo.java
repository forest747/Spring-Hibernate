package com.dennis.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dennis.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			//	query students: lastName='Jo'
			theStudents = session.createQuery("from Student s where s.lastName='Jo'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name Jo");
			displayStudents(theStudents);
			
			//	query students: lastName='Jo'
			theStudents = session.createQuery("from Student s where s.lastName='Jo' OR s.firstName='Mike'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name Jo OR firt name Mike");
			displayStudents(theStudents);
			
			// query students where like email LIKE '%.com'
			System.out.println("\n\nStudents whose have email ends with .com");
			theStudents = session.createQuery("from Student s where s.email LIKE '%.com'").getResultList();
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
