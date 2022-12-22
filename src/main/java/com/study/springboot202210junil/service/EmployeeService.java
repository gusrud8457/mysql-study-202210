package com.study.springboot202210junil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot202210junil.repository.EmployeeRepository;
import com.study.springboot202210junil.web.dto.EmpDto;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public int addEmployee(EmpDto empDto) {
		return 
	}

}
