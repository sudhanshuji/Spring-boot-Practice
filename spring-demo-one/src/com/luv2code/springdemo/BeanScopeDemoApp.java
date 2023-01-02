package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		//retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// call the methods on bean
		
		boolean result = (theCoach==alphaCoach);
		System.out.println("Pointing to the same object "+result);
		System.out.println("Memory location for theCoach "+theCoach);
		System.out.println("Memory location for theCoach "+alphaCoach);
		
		//close the context
		context.close();
	}

}
