package com.practice.employee.app.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =  "com.practice.employee.app" )
public class EmployeeCourseApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCourseApp.class, args);
	}

}
