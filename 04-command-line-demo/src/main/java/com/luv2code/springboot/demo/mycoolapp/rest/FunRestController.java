package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return hello world

	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// expose "/workout" that returns daily workout task
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	// expose "/fortune" that returns daily fortune
	@GetMapping("/fortune")
	public String getDailyFourtune() {
		return "Today is your lucky day";
	}

}
