package com.luv2code.aopdemo;

public class Account {
	private String name;
	private String level;
	
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Account(String name, String email) {
		this.name = name;
		this.level = email;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the level
	 */
	public String getEmail() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setEmail(String email) {
		this.level = email;
	}




	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	
	
	
	
}
