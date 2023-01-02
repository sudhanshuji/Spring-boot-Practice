package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

//			
			// create new objects
			Instructor tempInstructor = new Instructor("Susan", "PPublic", "susan.public@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http:/www.susangames.com/youtube",
					"Playing Video Games!!!");


			// associate the objects

			tempInstructor.setInstrutorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//Note this will also save the InstructorDetails Object
			//because of CascadeType.ALL
			System.out.println("Saving instructor : "+tempInstructor);
			session.save(tempInstructor);

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
