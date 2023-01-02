package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\n=====>>>>>> Executing @AfterThrowing on method: "+method);
		
		
		// log the exception
		System.out.println("the exception is "+ theExc);
		
		
	}

	
	// add a new advice for @Afterreturning on the findAccounts method
	
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,
			List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\nExecuting @AfterReturning on method : "+method);
		// print out the results of the method call
		System.out.println("\n====>>>>>> result is : "+result);
		
		// let's post process the data ..... modify it :-
		
		// convert the account names to uppercase
		convertAccountNamestoUpperCase(result);
		System.out.println("\n ========>>>>>>>>> result is "+result);
		
		
		
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
		System.out.println("\n==========>>>>>>>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
//		System.out.println(theJoinPoint.getSignature());
		System.out.println("Method : "+methodSign);
		
		
		// display the method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		//loop through args
		
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account email: "+theAccount.getEmail());
			}
		}
		
		
		
		
	}

	
	
	
	
	
	
}
