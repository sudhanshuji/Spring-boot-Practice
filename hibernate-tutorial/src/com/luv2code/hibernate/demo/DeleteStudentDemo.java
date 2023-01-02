package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int studentId = 1;
			
			session.beginTransaction();
			
			System.out.println("\n getting student with Id : "+studentId);
			
			

			// retrieving student with studentId
			Student myStudent = session.get(Student.class, studentId);
			
			//delete student
			
			//session.delete(myStudent);
			
			
			// delete studentId = 2
			
			session.createQuery("delete from Student where id = 2").executeUpdate();

						
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}

	}

}
