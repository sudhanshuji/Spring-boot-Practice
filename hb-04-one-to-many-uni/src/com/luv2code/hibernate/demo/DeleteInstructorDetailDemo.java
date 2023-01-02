package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

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

			// get the instructor detail
			int theId = 3;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("Instructor detail retrieved -: " + tempInstructorDetail);

			// print the associated constructor
			System.out.println("Print the associated instructor : " + tempInstructorDetail.getInstructor());

			// now lets delete the instructor detail
			System.out.println("Deleting tempInsatructor detail : " + tempInstructorDetail);
			
			
			//remove the associated object reference
			// break bideirectional link
			
			tempInstructorDetail.getInstructor().setInstrutorDetail(null);
			
			
			session.delete(tempInstructorDetail);
			// commit transaction

			session.getTransaction().commit();
			System.out.println("Done !!");

		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
