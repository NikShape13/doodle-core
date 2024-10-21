package com.doodle.core.spring.myOwnValidationAnnotations;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorConstraint implements ConstraintValidator<PasswordValidator, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<Character> checkForDigit =  value.chars().mapToObj(e -> (char)e).filter(ch->Character.isDigit(ch)).collect(Collectors.toList());
		List<Character> checkForChars = value.chars().mapToObj(e -> (char)e).filter(ch->Character.isLetter(ch)).collect(Collectors.toList());
		
		if(checkForDigit.size()>=3 && checkForChars.size()>=2) {
			return true;
		}
		return false;
	}

}
