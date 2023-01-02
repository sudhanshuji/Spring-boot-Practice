package com.practice.employee.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

	@RequestMapping("/hello1")
	@ResponseBody
	public String helloGFG() {
		return "<h2>From second controller!</h2>";
	}

}
