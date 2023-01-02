package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;
			// start a transaction
			session.beginTransaction();

			// getting student with id
			System.out.println("\n getting student with id : " + studentId);

			// retrieving student with studentId
			Student myStudent = session.get(Student.class, studentId);

			// updating student's first name
			System.out.println("Updating student");
			myStudent.setFirstName("Scooby");

			// commiting the transaction
			session.getTransaction().commit();
			
			//New code
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\n Updating emails for all the students");
			
			session.createQuery("update Student set email = 'Mary@gmail.com' where firstName = 'Mary'").executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
