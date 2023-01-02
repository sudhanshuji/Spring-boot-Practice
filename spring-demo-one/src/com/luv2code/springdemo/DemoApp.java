package com.luv2code.springdemo;

import java.io.Closeable;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		HockeyCoach hCoach = context.getBean("myHockeyCoach", HockeyCoach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(hCoach.getEmailAddress());
		System.out.println(hCoach.getTeamName());
		//close the context
		context.close();
	}

}
