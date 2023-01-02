package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
//	@Qualifier("happyFortuneService")
//	private FortuneService fortuneService;
	
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		
//		System.out.println(">>>TennisCoach : inside parameterized constructor");
//		this.fortuneService = fortuneService;
//	}

	public TennisCoach() {
		super();
		System.out.println(">>>TennisCoach : Inside default constructor");
	}
	
	// define my init method 
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">>>Inside my startup method : doing the startups");
	}
	
	
    //define my destroy method 
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">>>Inside my destroy method : doing the cleanUps");
	}

	/**
	 * @param fortuneService the fortuneService to set setter method
	 */
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.
	 * println(">>>TennisCoach : Inside setter methods setFortuneService()");
	 * this.fortuneService = fortuneService; }
	 */
	
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println(">>>> inside method to perform DO some crazy stuff");
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
