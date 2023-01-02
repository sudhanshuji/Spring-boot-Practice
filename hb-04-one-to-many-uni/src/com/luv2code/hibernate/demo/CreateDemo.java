package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

//			// create the objects
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http:/www.luv2code.com/youtube",
//					"love to code!!!");
			
			// create new objects
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "Patel@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http:/www.patelMusic.com/youtube",
					"Playing Guitar!!!");


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

			// My New Code

//			// find out the student's id: Primary key
//			System.out.println("saved student generatedId is" + student.getId());
//
//			// now get a new session and start transaction
//			Session getSession = factory.getCurrentSession();
//			getSession.beginTransaction();
//
//			// retrieve student based on the id :primary key
//			getSession.get(Student.class, student.getId());
//			System.out.println("get complete: " + student);
//
//			// commit the transaction
//			getSession.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
