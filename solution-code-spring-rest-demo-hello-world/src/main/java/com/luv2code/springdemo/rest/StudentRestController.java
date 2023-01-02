package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> thestudents;

	// define @PostConstruct to load the student data... only once!
	@PostConstruct
	public void loadData() {
		thestudents = new ArrayList<Student>();

		thestudents.add(new Student("Poornima", "Patel"));
		thestudents.add(new Student("Mario", "Rossi"));
		thestudents.add(new Student("Mary", "Smith"));
	}
	// define and end-point for "/students" - return list of students

	@GetMapping("/students")
	public List<Student> getStudents() {

		return thestudents;
	}

	// define endpoint for "/students/{studentId}" --> return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudebtById(@PathVariable int studentId) {
		// just index into the list and keep it simple for now

		// check the studentId against the list size
		if (studentId >= thestudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found :-" + studentId);
		}
		return thestudents.get(studentId);
	}

	
}
