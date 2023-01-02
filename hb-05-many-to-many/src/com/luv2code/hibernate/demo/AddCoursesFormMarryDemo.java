package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesFormMarryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the student marry from the database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);

			System.out.println("Loaded student : " + tempStudent);
			System.out.println("Course : " + tempStudent.getCourses());

			// create more courses

			Course tempCourse1 = new Course("Rubik's Cube - How to speed cube");
			Course tempCourse2 = new Course("Atari 2600 - Game development");

			// add student to the courses

			tempCourse1.addStudents(tempStudent);
			tempCourse2.addStudents(tempStudent);

			// save the courses

			session.save(tempCourse1);
			session.save(tempCourse2);

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
