package de.emma.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.emma.model.Employee;

public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName");
		ValidationUtils.rejectIfEmpty(errors, "adress", "error.adress");
		ValidationUtils.rejectIfEmpty(errors, "zip", "error.zip");
		ValidationUtils.rejectIfEmpty(errors, "city","error.city");
		ValidationUtils.rejectIfEmpty(errors, "salary", "error.salary");
		ValidationUtils.rejectIfEmpty(errors, "department", "error.department");
		ValidationUtils.rejectIfEmpty(errors, "title", "error.title");
		ValidationUtils.rejectIfEmpty(errors, "holidays", "error.holidays");
	}

}
