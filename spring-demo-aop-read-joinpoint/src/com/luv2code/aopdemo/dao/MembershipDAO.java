package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addSillyMember() {
		System.out.println(getClass()+"Doing stuff : Adding some membership account");
		return true;
	}
	
	public void goToSleep() {
		System.out.println("Go To Sleep");
	}
	
}
