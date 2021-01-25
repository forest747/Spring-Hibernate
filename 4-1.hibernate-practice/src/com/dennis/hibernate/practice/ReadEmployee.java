package com.dennis.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dennis.hibernate.practice.entity.Employee;

public class ReadEmployee {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int employeeId = 3;

			// find out the employee's id: primary key
			System.out.println("We will find the employee that has id: " + employeeId);

			// start a transaction
			session.beginTransaction();
			
			// retrieve employee based on the id
			Employee myEmployee = session.get(Employee.class, employeeId);
			System.out.println("Get complete: " + myEmployee);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}
}
