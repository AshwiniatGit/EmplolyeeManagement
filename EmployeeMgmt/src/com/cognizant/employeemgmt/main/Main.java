package com.cognizant.employeemgmt.main;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.employeemgmt.beans.Employee;
import com.cognizant.employeemgmt.service.EmployeeService;
import com.cognizant.employeemgmt.service.EmployeeServiceImpl;

public class Main {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		
		//Adding New Employee
		Employee employee = new Employee();
		employee.setEmployeeId("764356");
		String insertResult = employeeService.addEmployee(employee);
		if("success".equals(insertResult))
			System.out.println("Record Added Succsessfully");
		else
			System.out.print("Not Done");
	
		
		
		
		//Update
		employee.setFirstName("Test");//Updated Values
		
		String updateResult = employeeService.updateEmployee(employee.getEmployeeId(), employee);
		if("Success".equals(updateResult))
			System.out.println("Updated Successfully");
		else
			System.out.print("Problem in Updating");
		
		
		//select specific ID
		Employee emp = employeeService.getEmployee(employee.getEmployeeId());
		System.out.println("ID: "+emp.getEmployeeId()+" First Name: "+emp.getFirstName()+" Last Name: "+emp.getLastName()+" Salary: "+emp.getSalary());
		
		//Delete
		String deleteResult = employeeService.deleteEmployee(employee.getEmployeeId());
		if("Success".equals(deleteResult))
			System.out.println("Record Deleted");
		else
			System.out.println("Problem in deleting");
		
		//select all records
		List<Employee> employees = employeeService.getEmployees();
		for(Employee e : employees){
			System.out.println("ID: "+e.getEmployeeId()+" First Name: "+e.getFirstName()+" Last Name: "+e.getLastName()+" Salary: "+e.getSalary());
		}
		
		//select employees by name
		List<Employee> employees1 = employeeService.getEmployeesByNames("Abhishek");
		for(Employee e : employees1){
			System.out.println("ID: "+e.getEmployeeId()+" First Name: "+e.getFirstName()+" Last Name: "+e.getLastName()+" Salary: "+e.getSalary());
		}
		
	}

}
