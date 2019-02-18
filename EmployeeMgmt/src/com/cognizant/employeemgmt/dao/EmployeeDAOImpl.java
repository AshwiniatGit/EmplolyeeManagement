package com.cognizant.employeemgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			preparedStatement.setString(3, employee.getLastName());
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
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
			String updateStatement ="update employeemgmt " +
					"set firstname = ?, lastname= ?, salary=? where employeeid= ?"; 
			connection = DBUtils.getConnection();
			
			
			try {
				preparedStatement = connection.prepareStatement(updateStatement);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setFloat(3, employee.getSalary());
				preparedStatement.setString(4, employee.getEmployeeId());
				preparedStatement.executeUpdate();
				return "Success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return "fail";
			}
			finally {
				DBUtils.closeConnection(connection);
			}
			
		
	}

	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		String deleteString = "delete from employeemgmt where employeeid= ?";
		
		try {
			preparedStatement = connection.prepareStatement(deleteString);
			preparedStatement.setString(1, id);
			int res = preparedStatement.executeUpdate();
			
			return "Success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}

	@Override
	public Employee getEmployee(String id) {
		// TODO Auto-generated method stub
		
		PreparedStatement preparedStatement=null;
		String getString ="Select * from employeemgmt where employeeid=?";
		ResultSet resultSet= null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String employeeId = resultSet.getString("Employeeid");
				Float salary = resultSet.getFloat("salary");
				Employee employee = new Employee(employeeId,firstName,lastName,salary);
				return employee;
			}
			else{
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}

	@Override
	public List<Employee> getEmployeesByNames(String name) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement preparedStatement=null;
		String getString ="Select * from employeemgmt where FirstName=?";
		ResultSet resultSet= null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String employeeId = resultSet.getString("Employeeid");
				Float salary = resultSet.getFloat("salary");
				Employee employee = new Employee(employeeId,firstName,lastName,salary);
				employees.add(employee);
			}
			return employees;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement preparedStatement=null;
		String getString ="Select * from employeemgmt";
		ResultSet resultSet= null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String employeeId = resultSet.getString("Employeeid");
				Float salary = resultSet.getFloat("salary");
				Employee employee = new Employee(employeeId,firstName,lastName,salary);
				employees.add(employee);
			}
			return employees;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}
}
