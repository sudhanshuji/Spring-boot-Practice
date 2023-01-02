package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k Daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	// add an init method

	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: inside method doMyStartUp");
	}

	// add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: inside method doMyCleanUp");
	}
}
