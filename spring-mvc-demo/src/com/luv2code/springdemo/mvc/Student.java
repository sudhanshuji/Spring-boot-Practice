package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.List;

public class Student {

	private String firstName;

	private String lastName;

	private String country;

	private LinkedHashMap<String, String> countryOptions;

	private String favourateLanguage;
	
	private List<String> operatingSystems;

	public Student() {
		super();
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("GE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States Of America");
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the countryOptions
	 */
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	/**
	 * @return the favourateLanguage
	 */
	public String getFavourateLanguage() {
		return favourateLanguage;
	}

	/**
	 * @param favourateLanguage the favourateLanguage to set
	 */
	public void setFavourateLanguage(String favourateLanguage) {
		this.favourateLanguage = favourateLanguage;
	}

	/**
	 * @param countryOptions the countryOptions to set
	 */
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	/**
	 * @return the operatingSystems
	 */
	public List<String> getOperatingSystems() {
		return operatingSystems;
	}

	/**
	 * @param operatingSystems the operatingSystems to set
	 */
	public void setOperatingSystems(List<String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	

}
