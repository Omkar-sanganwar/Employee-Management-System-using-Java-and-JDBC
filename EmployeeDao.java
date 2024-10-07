package com.dao;

import com.entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	private Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("MySQL Driver not found.");
		}
		String URL = "jdbc:mysql://localhost:3307/EmployeeDB";
		String USER = "root";
		String PASSWORD = "root";
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String query = "SELECT * FROM Employee";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setDepartment(rs.getString("department"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setHiringDate(rs.getDate("hiringDate"));
				employee.setAddress(rs.getString("address"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public int insertEmployee(Employee employee) {
		String query = "INSERT INTO Employee (id, name, department, salary, hiringDate, address) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getDepartment());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, new java.sql.Date(employee.getHiringDate().getTime()));
			ps.setString(6, employee.getAddress());
			return ps.executeUpdate(); // returns the number of affected rows
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; // return 0 if insertion fails
		}
	}

	public int deleteEmployee(int id) {
		String query = "DELETE FROM Employee WHERE id = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			return ps.executeUpdate(); // returns the number of affected rows
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; // return 0 if deletion fails
		}
	}

	public int updateEmployee(Employee employee) {
		String query = "UPDATE Employee SET name = ?, department = ?, salary = ?, hiringDate = ?, address = ? WHERE id = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDepartment());
			ps.setDouble(3, employee.getSalary());
			ps.setDate(4, new java.sql.Date(employee.getHiringDate().getTime()));
			ps.setString(5, employee.getAddress());
			ps.setInt(6, employee.getId());
			return ps.executeUpdate(); // returns the number of affected rows
		} catch (SQLException e) {
			e.printStackTrace();
			return 0; // return 0 if update fails
		}
	}
}
