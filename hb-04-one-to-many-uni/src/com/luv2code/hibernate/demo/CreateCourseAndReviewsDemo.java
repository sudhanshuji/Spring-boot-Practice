package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

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
			Course tempCourse = new Course("Pacman - How to Score One Billio Points");
			
			//add some reviews
			tempCourse.addReviews(new Review("Great Course........... Loved It"));
			tempCourse.addReviews(new Review("Cool Course........... Loved It"));
			tempCourse.addReviews(new Review("Amazing Course........... Loved It"));
			tempCourse.addReviews(new Review("Fantastic Course........... Loved It"));
			tempCourse.addReviews(new Review("What a dumb course!!...you are an idiot"));
			
			
			
			// save the course and leaverage the cascade all-:
			
			session.save(tempCourse);
			
			

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !!");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
