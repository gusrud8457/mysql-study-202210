package com.study.springboot202210junil.web.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.study.springboot202210junil.web.dto.CmResqDto;

import exception.CustomTestException;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	@ExceptionHandler(CustomTestException.class)
	public ResponseEntity<?> testException(CustomTestException e){
		return ResponseEntity.badRequest().body(new CmResqDto<>(e.getMessage(), e.getErrorMap()));		
	}
}
