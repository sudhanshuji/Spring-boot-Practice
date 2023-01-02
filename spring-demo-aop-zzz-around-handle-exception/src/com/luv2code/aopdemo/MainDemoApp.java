package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
		// get the bean from container
			AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
			MembershipDAO theMemberShipDAO = context.getBean("membershipDAO",MembershipDAO.class);
			
		// call the methods on the bean
			Account theAccount = new Account();
			theAccount.setEmail("myemail@email.com");
			theAccount.setName("MyName");
			theAccountDAO.addAccount(theAccount,true);
			theAccountDAO.doWork();
			
			
//			call the accountDAO getter/stter method
			theAccountDAO.setName("fooBar");
			theAccountDAO.setServiceCode("silver");
			
			String name = theAccountDAO.getName();
			String serviceName = theAccountDAO.getServiceCode();
			
			
			
			theMemberShipDAO.addSillyMember();
			theMemberShipDAO.goToSleep();
			
			
		
		
		
		// close the context
		context.close();
		
	}

}
