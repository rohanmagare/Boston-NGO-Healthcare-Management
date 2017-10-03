package com.neu.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Donor;

public class DonorValidator implements Validator {

	@Override
	public boolean supports(Class<?> classz) {

		return classz.equals(Donor.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.companyName",
				"Company Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "error.invalid.ssn", "SSN Required");

		if (errors.hasErrors()) {
			return;
		}
	}

}
