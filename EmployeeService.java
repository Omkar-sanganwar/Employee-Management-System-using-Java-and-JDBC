package com.service;

import com.dao.EmployeeDao;
import com.entity.Employee;

import java.util.List;

public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDao();

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public int insertEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}

	public int deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
}
