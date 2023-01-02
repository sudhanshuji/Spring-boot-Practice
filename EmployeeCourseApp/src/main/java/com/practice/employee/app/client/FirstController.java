/**
 * 
 */
package com.practice.employee.app.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author saura
 *
 */
@Controller
public class FirstController {

	@RequestMapping("/hello")
	@ResponseBody
	public String helloGFG() {
		return "Hello World!";
	}

}
