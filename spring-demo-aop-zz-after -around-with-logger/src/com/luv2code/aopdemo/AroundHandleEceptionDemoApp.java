package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleEceptionDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundHandleEceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\n Main Program: ArroundDemoApp");

		myLogger.info("calling getFortune");
		
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("\n My fortune is : " + data);

		myLogger.info("\n Finished");

		// close the context
		context.close();

	}

}
