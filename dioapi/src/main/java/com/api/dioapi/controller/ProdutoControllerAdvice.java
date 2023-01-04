package com.api.dioapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.dioapi.exception.ProductNegativePriceException;
import com.api.dioapi.exception.ProductNullException;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductNullException.class)
	public ResponseEntity<Object> capturaErroNull(){
		
		Map<String,Object> body = new HashMap<String,Object>();
		body.put("message", "Verifique se todos os campos estão preenchidos");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}
	
	@ExceptionHandler(ProductNegativePriceException.class)
	public ResponseEntity<Object> capturaErroNumeroNegativo(){
		
		Map<String,Object> body = new HashMap<String,Object>();
		body.put("message", "Preço negativo, verifique!!!");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
	}
	
}
