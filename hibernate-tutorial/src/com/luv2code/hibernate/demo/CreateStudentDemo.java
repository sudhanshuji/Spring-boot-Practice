package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create a session object
			System.out.println("Creating a new student object");
			// Student student = new Student("Paul", "wall", "paul@luv2code.com");
//			Student student1 = new Student("John", "Doe", "john@luv2code.com");
//			Student student2 = new Student("Mary", "Pulic", "mary@luv2code.com");
//			Student student3 = new Student("Bonita", "Applebom", "bonita@luv2code.com");
			
			Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
//			session.save(student1);
//			session.save(student2);
//			session.save(student3);
			
			session.save(student);

			// commit transaction

			session.getTransaction().commit();
			System.out.println("Done !!");
			
			
			
			//My New Code
			
			//find out the student's id: Primary key
			System.out.println("saved student generatedId is"+student.getId());
			
			
			// now get a new session and start transaction
			Session getSession = factory.getCurrentSession();
			getSession.beginTransaction();
			
			//retrieve student based on the id :primary key
			getSession.get(Student.class, student.getId());
			System.out.println("get complete: "+student);
			
			//commit the transaction
			getSession.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
