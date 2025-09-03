package com.ashok.employeemngmntservice.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ashok.employeemngmntservice.model.Employee;
@Service
public class EmployeeService {
	 private List<Employee> employees = Arrays.asList(
		        new Employee(101, "Ashok", "IT", 70000, 28),
		        new Employee(102, "Neha", "HR", 50000, 22),
		        new Employee(103, "Ravi", "Finance", 90000, 32),
		        new Employee(104, "Priya", "IT", 65000, 25),
		        new Employee(105, "Amit", "Finance", 55000, 24),
		        new Employee(106, "Sneha", "HR", 48000, 19)
		    );
	 public List<Employee> getAllEmployees() {
	        return employees;
	    }

	    public List<Employee> getHighSalaryEmployees() {
	        return employees.stream()
	                .filter(e -> e.getSalary() > 60000)
	                .toList();
	    }

	    public List<Employee> getSortedBySalary() {
	        return employees.stream()
	                .sorted(Comparator.comparing(Employee::getSalary).reversed())
	                .toList();
	    }

	    public Map<String, List<Employee>> groupByDepartment() {
	        return employees.stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment));
	    }

	    public Map<Boolean, List<Employee>> partitionByAge() {
	        return employees.stream()
	                .collect(Collectors.partitioningBy(e -> e.getAge() >= 25));
	    }

	    public Optional<Employee> getHighestPaid() {
	        return employees.stream()
	                .max(Comparator.comparing(Employee::getSalary));
	    }

	    public Map<String, Double> getAverageSalaryByDept() {
	        return employees.stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment,
	                        Collectors.averagingDouble(Employee::getSalary)));
	    }

	    public double getTotalPayroll() {
	        return employees.stream()
	                .mapToDouble(Employee::getSalary)
	                .sum();
	    }

	    public Map<String, Long> getEmployeeCountByDept() {
	        return employees.stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	    }
}
