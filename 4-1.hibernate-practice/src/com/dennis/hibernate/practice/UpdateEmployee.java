package com.dennis.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dennis.hibernate.practice.entity.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int employeeId = 1;

			// start a transaction
			session.beginTransaction();

			// retrieve employee based on the id
			System.out.println("\nGetting employee with id: " + employeeId);

			Employee myEmployee = session.get(Employee.class, employeeId);

			System.out.println("Updating employee ...");
			myEmployee.setFirstName("Nancy");

			// commit transaction
			session.getTransaction().commit();

			// version 2
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update company for all employees
			System.out.println("Update company for all employees");

			session.createQuery("update Employee set company='Top Java Coders Inc'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}
}
