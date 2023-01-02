package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDAOjpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOjpaImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;

	}

	@Override
	public List<Employee> findAll() {
		System.out.println("I am inside JPA Method");
		//craete a query 
		Query theQuery = entityManager.createQuery("from Employee");
		
		//execute the query and get resultlist
		List<Employee> employees = theQuery.getResultList();
		
		
		//return the results
		return employees;
	}

	@Override
	public Employee findEmployeeById(int theId) {
		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//return employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//save or update the employee
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db ....so we can get generated id for insert/save
		
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id = :employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
