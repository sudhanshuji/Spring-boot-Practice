package com.luv2code.springdemo;

public class HockeyCoach implements Coach {

	
	

	private String emailAddress;
	private String teamName;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeamName() {
		return teamName;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeamName(String team) {
		this.teamName = team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
