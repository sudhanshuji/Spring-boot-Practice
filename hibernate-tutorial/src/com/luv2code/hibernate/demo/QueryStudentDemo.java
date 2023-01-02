package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents= session.createQuery("from Student").list();
			
			
			//display students
			displayStudents(theStudents);
			
			//query the students whose last name is doe
			List<Student> doeStudents= session.createQuery("from Student s  where s.lastName = 'Doe'").list();
			
			
			//display students
			System.out.println("students whose last name is Doe -:");
			displayStudents(doeStudents);
			
			
			//query the students whose last name is doe or first name daffy
			List<Student> studentList= session.createQuery("from Student s  where s.lastName = 'Doe' OR s.firstName = 'Daffy'").list();
			
			
			//display students
			System.out.println("students whose last name is Doe or first name is daffy -:");
			displayStudents(studentList);
			
			
			//query the students whose email id ends with @luv2code.com
			List<Student> studentWithEmails= session.createQuery("from Student s  where s.email like '%luv2code.com'").list();
			
			
			//display students
			System.out.println("students whose emil id ends with luv2code.com -:");
			displayStudents(studentWithEmails);
			
			
			
			// commit transaction

			session.getTransaction().commit();
			
			
			
			
					
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			
			
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student stud : theStudents) {
			System.out.println("\n\n\n"+stud);
		}
	}

}
