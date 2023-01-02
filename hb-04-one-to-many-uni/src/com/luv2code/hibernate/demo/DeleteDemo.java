package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			//get instructor primary key
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			System.out.println("Found Instructor -: "+tempInstructor);
			
			//delete instructor
			if (tempInstructor != null) {
				System.out.println("Deleting :- "+tempInstructor);
				// note that it will also delete the associated instructor detail 
				//beacause of CascadeType.All 
				session.delete(tempInstructor);
			}

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
