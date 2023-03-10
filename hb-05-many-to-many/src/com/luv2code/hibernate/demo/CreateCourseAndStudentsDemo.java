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

public class CreateCourseAndStudentsDemo {

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
			
			
			// create a course
			Course tempCourse = new Course("Pacman - How to Score One Billio Points");

			// save the course and leaverage the cascade all-:
			
			System.out.println("Saving the course");

			session.save(tempCourse);
			
			System.out.println("saving is complete");
			
			// create the students
			Student tempStudent1 = new Student("John", "Doe", "doe@gmail.com"); 
			Student tempStudent2 = new Student("Mary", "Public", "public@gmail.com");
			
			//add student to the course
			
			tempCourse.addStudents(tempStudent1);
			tempCourse.addStudents(tempStudent2);
			
			
			//save the students
			System.out.println("\n saving the students.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved student : "+tempCourse.getStudents());
			

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
