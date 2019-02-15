package com.cognizant.employeemgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.employeemgmt.beans.Employee;
import com.cognizant.employeemgmt.utils.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection connection;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
	//	ResultSet resultSet = null;
		String insertStatement ="insert into employeemgmt"
				+ "(employeeid,firstname,lastname,salary) "+ "values(?,?,?,?)";
		connection = DBUtils.getConnection();
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setFloat(4, employee.getSalary());
			
			int res = preparedStatement.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally{
			DBUtils.closeConnection(connection);
		}
		
	}

	@Override
	public String updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesByNames(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
}
