package com.doodle.core.spring.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<IncorrectData> handlerException(Exception exception){
		IncorrectData data = new IncorrectData();
		data.setInfo(exception.getMessage());
		return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
	}

}
