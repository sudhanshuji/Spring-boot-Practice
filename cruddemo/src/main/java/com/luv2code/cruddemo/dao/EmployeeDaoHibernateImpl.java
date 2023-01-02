package com.luv2code.cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get the result list
		List<Employee> employees = theQuery.getResultList();
		// return the result
		return employees;
	}

	@Override
	public Employee findEmployeeById(int theId) {
		//get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		//return the employee
		return theEmployee;
		
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.persist(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		//get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete employee
		MutationQuery theQuery = currentSession.createMutationQuery(""
				+ "delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
