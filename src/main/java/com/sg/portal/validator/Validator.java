package com.sg.portal.validator;

import org.springframework.stereotype.Component;

@Component
public interface Validator {
	
	public <T> boolean createValidate(T data);
	
}
