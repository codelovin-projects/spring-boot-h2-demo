package com.codelovin.h2demo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) throws Exception {
		CustomExceptionResponse exres = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exres, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public final ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request) throws Exception {
		CustomExceptionResponse exres = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exres, HttpStatus.NOT_FOUND);
	}
}
