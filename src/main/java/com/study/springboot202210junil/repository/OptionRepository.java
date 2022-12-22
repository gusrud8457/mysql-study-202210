package com.study.springboot202210junil.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot202210junil.web.dto.CategoryDto;

@Mapper
public interface OptionRepository {
	public int saveCategory(CategoryDto categoryDto);
	public List<CategoryDto> getCategories();
	public int modifyCategory(CategoryDto categoryDto);
	

}
