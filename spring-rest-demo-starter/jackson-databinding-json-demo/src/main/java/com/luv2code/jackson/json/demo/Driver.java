package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read json file and Map/Convert to java POJO

			// data/sample-lite.json
			Student theStudent = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			// print first name and lastname
			System.out.println("First Name = "+theStudent.getFirstName());
			System.out.println("Last Name = "+theStudent.getLastName());
			System.out.println("Address = "+theStudent.getAddress().getStreet());
			System.out.println("Studen Details = "+theStudent.toString());
			
			// print out the student city and street and the languages
			Address theAddress = theStudent.getAddress();
			
			System.out.println("Street = "+theAddress.getStreet());
			System.out.println("City = "+theAddress.getCity());
			
			for (String language:theStudent.getLanguages()) {
				System.out.println("  "+language);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
