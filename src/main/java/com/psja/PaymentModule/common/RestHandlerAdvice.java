package com.psja.PaymentModule.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

@ControllerAdvice
public class RestHandlerAdvice {

	@ExceptionHandler( value = Exception.class )
	public ResponseEntity<String> handleException( Exception exp ){
		System.out.println("EXCEPTION"+exp.getMessage());
		return ResponseEntity.status(400).contentType( MediaType.TEXT_PLAIN ).body("FAILURE");
	}
	
}
