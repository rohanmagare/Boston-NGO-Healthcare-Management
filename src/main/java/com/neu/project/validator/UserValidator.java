
package com.neu.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.User;

public class UserValidator implements Validator {

	public boolean supports(Class<?> aClass) {

		return aClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName",
				"First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.userName", "Username Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.phoneNumber",
				"Phone Number Required");
		if (errors.hasErrors()) {
			return;
		}
	}

}
