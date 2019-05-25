package com.xebia.portal.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.portal.model.Employee;
import com.xebia.portal.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> save(Optional<Employee> emp){
		if (emp.isPresent()) {
			return Optional.of(employeeRepository.save(emp.get()));
		}
		return null;
	}
	
	public List<Employee> listEmployee(){
		return employeeRepository.findAll();
	}
}
