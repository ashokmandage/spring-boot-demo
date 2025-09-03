package com.ashok.employeemngmntservice.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.employeemngmntservice.model.Employee;
import com.ashok.employeemngmntservice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return service.getHighSalaryEmployees();
    }

    @GetMapping("/sorted-salary")
    public List<Employee> sortedBySalary() {
        return service.getSortedBySalary();
    }

    @GetMapping("/group-by-dept")
    public Map<String, List<Employee>> groupByDept() {
        return service.groupByDepartment();
    }

    @GetMapping("/partition-by-age")
    public Map<Boolean, List<Employee>> partitionByAge() {
        return service.partitionByAge();
    }

    @GetMapping("/highest-paid")
    public Optional<Employee> highestPaid() {
        return service.getHighestPaid();
    }

    @GetMapping("/avg-salary-by-dept")
    public Map<String, Double> avgSalaryByDept() {
        return service.getAverageSalaryByDept();
    }

    @GetMapping("/total-payroll")
    public double totalPayroll() {
        return service.getTotalPayroll();
    }

    @GetMapping("/count-by-dept")
    public Map<String, Long> countByDept() {
        return service.getEmployeeCountByDept();
    }
}
