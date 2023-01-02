package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach yoCoach = context.getBean("yourCoach", Coach.class);
		Coach volleyCoach = context.getBean("ourCoach", Coach.class);
		
		
		// call methods on bean
				System.out.println(theCoach.getDailyWorkout());
				System.out.println(theCoach.getDailyFortune());
				System.out.println(yoCoach.getDailyWorkout());
				System.out.println(volleyCoach.getDailyWorkout());
		// close the context
				context.close();
	}

}
