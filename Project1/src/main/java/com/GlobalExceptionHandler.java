package com;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exception.AdminNotFoundException;
import com.exception.CabNotFoundException;
import com.exception.CustomerNotFoundException;
import com.exception.DriverNotFoundException;
import com.exception.ErrorMessage;
import com.exception.InvalidLoginException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DriverNotFoundException.class)
	public @ResponseBody ErrorMessage checkDriverNotFoundException(DriverNotFoundException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public @ResponseBody ErrorMessage checkAdminNotFoundException(AdminNotFoundException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorMessage checkCustomerNotFoundException(CustomerNotFoundException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}
	
	@ExceptionHandler(CabNotFoundException.class)
	public @ResponseBody ErrorMessage checkCabNotFoundException(CabNotFoundException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	public @ResponseBody ErrorMessage checkInvalidLoginException(InvalidLoginException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	

}
