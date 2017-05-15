package de.emma.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.emma.model.Employee;

public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> paramClass) {

		return Employee.class.equals(paramClass);

	}

	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "valid.employee");

	}

}
