package com.neu.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {

		return aClass.equals(Employee.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.salary", "salary Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "error.invalid.ssn", "SSN Required");

		if (errors.hasErrors()) {
			return;
		}
	}
}
