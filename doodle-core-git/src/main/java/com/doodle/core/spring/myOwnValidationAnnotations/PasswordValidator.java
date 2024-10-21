package com.doodle.core.spring.myOwnValidationAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PasswordValidatorConstraint.class)
public @interface PasswordValidator {
	public String message() default "Password should consist of latin letters and digits"; 
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
