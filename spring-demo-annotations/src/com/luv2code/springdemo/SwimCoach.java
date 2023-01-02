package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return " Swim 1000 meters as a warmup";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	
	

}
