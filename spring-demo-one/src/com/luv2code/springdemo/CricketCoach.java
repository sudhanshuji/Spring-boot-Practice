package com.luv2code.springdemo;

public class CricketCoach implements Coach{
	private FortuneService fortunrService;
	
	
	public CricketCoach() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setFortuneService(FortuneService fortunrService) {
		this.fortunrService = fortunrService;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice bowling for 15 minutes";
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just do it: Today is your lucky day";
	}
	
	
}
