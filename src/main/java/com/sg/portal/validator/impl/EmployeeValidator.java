package com.sg.portal.validator.impl;

import org.springframework.stereotype.Component;

import com.sg.portal.model.Employee;
import com.sg.portal.validator.Validator;

@Component(value = "employeeValidator")
public class EmployeeValidator implements Validator {
	
	@Override
	public <T> boolean createValidate(T data){	
		
		if (data instanceof Employee) {
			//TODO validation logic.
			return true;
		}
		return false;
	}
}
