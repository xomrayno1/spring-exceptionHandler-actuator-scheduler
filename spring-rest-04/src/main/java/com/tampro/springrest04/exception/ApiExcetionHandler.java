package com.tampro.springrest04.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExcetionHandler {
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		//1. create payload containing exception details
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(e.getMessage(),
				e,
				badRequest,
				ZonedDateTime.now(ZoneId.of("Z")));
		//2. return response entity 
		return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
	}

}
