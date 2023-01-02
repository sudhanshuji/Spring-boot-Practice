package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;

			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("luv2code : Instructor : " + tempInstructor);
			
			System.out.println("luv2code : Courses : " + tempInstructor.getCourses());

			// commit transaction

			session.getTransaction().commit();
			System.out.println("Done !!");
			//closing the session intentionally
			// executing the below code will result in an issue LazyLoadingInirtializationException
			// Option 1 :- call getter method while the session is open
			session.close();
			
			System.out.println("The session is now closed!!");
			
			//Since courses are lazy loaded so thuis should fail
			
			//get courses for the instructor

			System.out.println("luv2code : Courses : " + tempInstructor.getCourses());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
