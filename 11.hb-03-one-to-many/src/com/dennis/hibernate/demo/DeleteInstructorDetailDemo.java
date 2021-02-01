package com.dennis.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dennis.hibernate.demo.entity.Instructor;
import com.dennis.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 2;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			
			/* 디테일만 삭제하고 instruct는 남기고 싶으면 아래 코드 삽입*/
			// remove the associate object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection issue
			session.close();
	
			factory.close();
		}
	}

}
