package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String data[] = {
			"Beware of the wolf in sheeps clothing",
			"Diligence is the mother pof goodluck",
			"The Journey is the reward"
	};
	
	// create a randome number generator
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		int result = myRandom.nextInt(data.length);
		String theFortune = data[result];
		return theFortune;
	}

}
