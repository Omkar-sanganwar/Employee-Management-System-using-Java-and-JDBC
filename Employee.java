package com.entity;

import java.util.Date;

public class Employee {
	private int id;
	private String name;
	private String department;
	private double salary;
	private Date hiringDate;
	private String address;

 	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.trim().split("\\s+").length >= 1) { // Allow single or multiple words
			this.name = name;
		} else {
			throw new IllegalArgumentException("Name should not be empty.");
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if (department.trim().split("\\s+").length >= 1) { // Allow single or multiple words
			this.department = department;
		} else {
			throw new IllegalArgumentException("Department should not be empty.");
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", hiringDate=" + hiringDate + ", address=" + address + "]";
	}
}
