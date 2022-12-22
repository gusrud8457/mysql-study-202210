package com.study.springboot202210junil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot202210junil.repository.OptionRepository;
import com.study.springboot202210junil.web.dto.CategoryDto;

@Service
public class OptionService {
	
	@Autowired
	private OptionRepository optionRepository;
	
	public int addCategory(CategoryDto categoryDto) {
		return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategoryId() : 0;
		
	}
	
	public List<CategoryDto> getcategories(){
		return optionRepository.getCategories();
	}
	
	public void modifyCategory(int categoryId, CategoryDto categoryDto) {
		categoryDto.setCategoryId(categoryId);
		optionRepository.modifyCategory(categoryDto);
	}

}
