package com.neu.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.UserException;
import com.neu.project.pojo.Employee;
import com.neu.project.pojo.User;

public class EmployeeDAO extends DAO {

	public EmployeeDAO() {

	}

	public void register(Employee em) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Employee emp = new Employee();
			emp.setBonus(em.getBonus());
			emp.setEmploymentType(em.getEmploymentType());
			emp.setProject(em.getProject());
			emp.setSalary(em.getSalary());
			emp.setSsn(em.getSsn());
			emp.setUser(em.getUser());
			emp.setProject(em.getProject());
			getSession().save(emp);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating employee: " + e.getMessage());
		}
	}

	public Employee getEmployeeByUserId(User u) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Employee where employeeId = :employeeId");
			q.setLong("employeeId", u.getUserId());
			Employee employee = (Employee) q.uniqueResult();
			commit();
			return employee;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get employee " + u.getFirstName(), e);
		}

	}

}
