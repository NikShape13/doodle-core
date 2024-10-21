package com.doodle.core.spring.myOwnValidationAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidatorConstraint implements ConstraintValidator<EmailValidator, String>{
	private String[] domens;
	
	@Override
	public void initialize(EmailValidator emailValid) {
		domens = emailValid.domens();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for(String domen: domens) {
			if(value.endsWith(domen))
				return true;
		}
		return false;
	}

}
