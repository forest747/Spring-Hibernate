package com.dennis.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dennis.hibernate.demo.entity.Course;
import com.dennis.hibernate.demo.entity.Instructor;
import com.dennis.hibernate.demo.entity.InstructorDetail;
import com.dennis.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Math");

			// add some reviews
			tempCourse.addReview(new Review("Gooooood"));
			tempCourse.addReview(new Review("Not Good"));
			tempCourse.addReview(new Review("Bad"));

			// save the course ... and leverage the cascade all
			// 아래의 출력 내 함수들은 LAZY에 영향을 주지 않음.
			System.out.println("Saving the Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());

			session.save(tempCourse);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// add clean up code
			session.close();

			factory.close();
		}
	}

}
