package com.tampro.springrest04.exception;

public class ApiRequestException extends RuntimeException{

	
	public ApiRequestException(String msg) {
		super(msg);
	}
	public ApiRequestException(String msg,Throwable throwable) {
		super(msg,throwable);
	}
}
