package com.cognizant.employeemgmt.main;

import com.cognizant.employeemgmt.beans.Employee;
import com.cognizant.employeemgmt.service.EmployeeService;
import com.cognizant.employeemgmt.service.EmployeeServiceImpl;

public class Main {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		Employee employee = new Employee();
		String result = employeeService.addEmployee(employee);
		if("success".equals(result))
			System.out.print("Record Added Succsessfully");
		else
			System.out.print("Not Done");
	}

}
