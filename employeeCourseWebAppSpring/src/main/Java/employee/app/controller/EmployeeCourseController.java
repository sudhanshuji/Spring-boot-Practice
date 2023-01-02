/**
 * 
 */
package employee.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Sudhanshu
 *
 *https://springjava.com/spring-mvc/spring-mvc-with-xml-configuration-example
 *
 */
@Controller
public class EmployeeCourseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String serveHomePage() {
		return "home";
	}
}
