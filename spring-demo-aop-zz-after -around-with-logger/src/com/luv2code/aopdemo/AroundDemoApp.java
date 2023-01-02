package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
		// get the bean from container
			TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
			
			
			System.out.println("\n Main Program: ArroundDemoApp");
			
			System.out.println("calling getFortune");
			
			String data = theFortuneService.getFortune();
			
			System.out.println("\n My fortune is : "+data);
			
			System.out.println("\n Finished");
					
		// close the context
		context.close();
		
	}

}
