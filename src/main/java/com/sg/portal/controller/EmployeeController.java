package com.sg.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.portal.model.Employee;
import com.sg.portal.service.EmployeeService;

@CrossOrigin("*")
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody(required = true) Employee emp){
				
		Optional<Employee> iEmp = Optional.of(emp);
			Optional<Employee> employee = employeeService.save(iEmp);
			if (employee.isPresent()) {
				return employee.get();
			}
		return null;
	}
	
	@GetMapping("/list")
	public List<Employee> listEmployee() {
		return employeeService.listEmployee();
	}
	
	
	

}
