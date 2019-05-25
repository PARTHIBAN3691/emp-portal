package com.xebia.portal.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.portal.model.Employee;
import com.xebia.portal.service.EmployeeService;
import com.xebia.portal.validator.Validator;
import com.xebia.portal.validator.impl.EmployeeValidator;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Validator employeeValidator;
	
	@CrossOrigin("*")
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody(required = true) Employee emp){
				
		Optional<Employee> iEmp = Optional.of(emp);
		if (iEmp.isPresent() && employeeValidator.createValidate(iEmp.get())) {
			Optional<Employee> employee = employeeService.save(iEmp);
			if (employee.isPresent()) {
				return employee.get();
			}
		}
		throw new WebApplicationException("There is an problem creating employee.", HttpStatus.BAD_REQUEST.value());
	}
	
	@CrossOrigin("*")
	@GetMapping(path="/list")
	public List<Employee> listEmployee() {
		return employeeService.listEmployee();
	}
	
	
	

}
