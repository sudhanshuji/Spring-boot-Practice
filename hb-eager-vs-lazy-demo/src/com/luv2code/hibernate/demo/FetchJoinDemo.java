package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i" + " JOIN FETCH i.courses" + " Where i.id =:theInstructorId",
					Instructor.class);
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("luv2code : Instructor : " + tempInstructor);

			// commit transaction

			session.getTransaction().commit();
			System.out.println("Done !!");
			// closing the session intentionally
			// executing the below code will result in an issue
			// LazyLoadingInirtializationException
			// Option 1 :- call getter method while the session is open
			session.close();

			System.out.println("The session is now closed!!");

			// Since courses are lazy loaded so thuis should fail

			// get courses for the instructor

			System.out.println("luv2code : Courses : " + tempInstructor.getCourses());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
