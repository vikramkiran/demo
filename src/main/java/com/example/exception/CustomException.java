package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public CustomException() {
		super();
		
	}

	public CustomException( final String errorMessage) {
		super(errorMessage);
		
	}

	
	
	

	
	
	

}
