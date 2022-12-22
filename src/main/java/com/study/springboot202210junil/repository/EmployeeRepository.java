package com.study.springboot202210junil.repository;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot202210junil.web.dto.EmpDto;

@Mapper
public interface EmployeeRepository {
	public int saveEmployee(EmpDto empDto);
	
}