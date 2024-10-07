package com.controller;

 
import com.entity.Employee;
import com.service.EmployeeService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n1. See Employees");
            System.out.println("2. Insert Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    private void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);
            employee.setHiringDate(new Date());
            employee.setAddress(address);

            int result = employeeService.insertEmployee(employee);
            if (result > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }
        } catch (Exception e) {
            System.out.println("Error while adding employee: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        int result = employeeService.deleteEmployee(id);
        if (result > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Failed to delete employee.");
        }
    }

    private void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter New Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Department: ");
            String department = scanner.nextLine();
            System.out.print("Enter New Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter New Address: ");
            String address = scanner.nextLine();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);
            employee.setHiringDate(new Date());
            employee.setAddress(address);

            int result = employeeService.updateEmployee(employee);
            if (result > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }
        } catch (Exception e) {
            System.out.println("Error while updating employee: " + e.getMessage());
        }
    }
}
