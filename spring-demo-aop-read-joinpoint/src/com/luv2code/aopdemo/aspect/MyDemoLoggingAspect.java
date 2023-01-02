package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
