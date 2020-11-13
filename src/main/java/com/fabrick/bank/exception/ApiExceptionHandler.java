package com.fabrick.bank.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {ResponseBodyError.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleApiExceptionHandler(ResponseBodyError ex){
		ApiException apiException = new ApiException(ex.getMessage(), ex.getStatu(), ZonedDateTime.now(ZoneId.of("Z")),ex.getMessages());
		return new ResponseEntity<Object>(apiException,HttpStatus.BAD_REQUEST);
	}

}
