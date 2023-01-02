package com.luv2code.cruddemo.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//add mapping for GET /employee/{employeeId}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findEmployeeById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id  not found "+employeeId);
			
		}
		return theEmployee;
	}
	
	//add mapping for POST /employees -add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//also just in case they ass an is in  the JSON ...set id as 0
		//this is to force a save of new item....instead of update
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for PUT /employees -update an existing employee
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			
			employeeService.save(theEmployee);
			
			return theEmployee;
		}
		
		//add mapping for Delete /employees/{employeeId} -add new employee
		@DeleteMapping("/employees/{employeeId}")
		public Employee addEmployee(@PathVariable int employeeId) {
			Employee tempEmployee = employeeService.findEmployeeById(employeeId);
			if(tempEmployee == null) {
				throw new RuntimeException("Employee with employee id "+employeeId+"not found");
				
			}
			else
				employeeService.deleteById(employeeId);

			
			return tempEmployee;
		}
}