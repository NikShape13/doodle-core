package com.doodle.core.spring.myOwnValidationAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidatorConstraint.class)
public @interface EmailValidator {
	public String[] domens() default {"mail.ru", "yandex.ru", "gmail.com"};
	public String message() default "invalid email";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
