package com.mainClass;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exception.DriverNotFoundException;
import com.exception.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DriverNotFoundException.class)
	public @ResponseBody ErrorMessage checkDriverNotFoundException(DriverNotFoundException de) {
		ErrorMessage driverError = new ErrorMessage(LocalDateTime.now(), de.getMessage());
		return driverError;
	}

}
