package com.cognizant.employeemgmt.service;

import java.util.List;

import com.cognizant.employeemgmt.beans.Employee;
import com.cognizant.employeemgmt.dao.EmployeeDAO;
import com.cognizant.employeemgmt.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService  {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(id, employee);
	}

	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployeesByNames(String name) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeesByNames(name);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

}
