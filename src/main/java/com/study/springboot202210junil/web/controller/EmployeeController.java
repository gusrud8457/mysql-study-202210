package com.study.springboot202210junil.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot202210junil.web.dto.EmpDto;

@RestController
public class EmployeeController {
	
	@PostMapping("/api/emp")
	public ResponseEntity<?> addEmployee(EmpDto empDto){
		return HttpStatus.CREATED();
	}

}
