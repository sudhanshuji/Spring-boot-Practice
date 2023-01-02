package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		// print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>>> Executing @Around on method: "+method);
		
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = null;
		try {
		result = theProceedingJoinPoint.proceed();
		}
		catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			
//			// give the user a custom message
//			result = "Major Accident!! But no worries,"
//					+ "your private AOP helicopter is on the way!";
			
			// rethrow exception
			throw e;
		}
		
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		
		myLogger.info("\n ====>>>> Duration : "+duration / 1000.0 +" Seconds");
		
		
		return result;
	}
	
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint) {
		// print out which method we are advising on
				String method = theJointPoint.getSignature().toShortString();
				myLogger.info("\n=====>>>>>> Executing @AfterFinally on method: "+method);
				
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJointPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>>>> Executing @AfterThrowing on method: "+method);
		
		
		// log the exception
		myLogger.info("the exception is "+ theExc);
		
		
	}

	
	// add a new advice for @Afterreturning on the findAccounts method
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,
			List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\nExecuting @AfterReturning on method : "+method);
		// print out the results of the method call
		myLogger.info("\n====>>>>>> result is : "+result);
		
		// let's post process the data ..... modify it :-
		
		// convert the account names to uppercase
		convertAccountNamestoUpperCase(result);
		myLogger.info("\n ========>>>>>>>>> result is "+result);
		
		
		
	}
	private void convertAccountNamestoUpperCase(List<Account> result) {
		// loop through accounts
		for (Account tempAccount : result) {
			String upperCaseName = tempAccount.getName().toUpperCase();
		
		// get uppercase version of name 
			tempAccount.setName(upperCaseName);
		
		
		//update the name of the account
		}
	}
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n==========>>>>>>>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
//		myLogger.info(theJoinPoint.getSignature());
		myLogger.info("Method : "+methodSign);
		
		
		// display the method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		//loop through args
		
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("account name: "+theAccount.getName());
				myLogger.info("account email: "+theAccount.getEmail());
			}
		}
		
		
		
		
	}

	
	
	
	
	
	
}
