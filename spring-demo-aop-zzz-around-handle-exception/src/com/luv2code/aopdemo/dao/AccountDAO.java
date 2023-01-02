package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	
	// add a new method : finAccounts()
	
	public List<Account> findAccounts(boolean tripWire){
		// for academic purpose ..... simulate an exception
		if (tripWire){
			throw new RuntimeException("No Soup for you!!!");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		// add them to account list
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount,boolean vipFlag) {
		System.out.println(getClass()+" : DOING MY DB WORK : ADDING AN ACCOUNT\n"
				+ "My name is : "+theAccount.getName()+
				"\n My Email is : "+theAccount.getEmail());
		
	}
	
	public boolean doWork() {
		System.out.println(getClass()+"do work : doWork()");
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		System.out.println(getClass()+"in getName");
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println(getClass()+"in setName()");
		this.name = name;
	}

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		System.out.println(getClass()+"in getServiceCode");
		return serviceCode;
	}

	/**
	 * @param serviceCode the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+"in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
