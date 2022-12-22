package com.study.springboot202210junil.web.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot202210junil.service.OptionService;
import com.study.springboot202210junil.web.dto.CategoryDto;


@RestController
@RequestMapping("/api/option")
public class OptionController {
	
		@Autowired
		private OptionService optionService;
	
		@PostMapping("/category")
		public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
			System.out.println(categoryDto);
			return ResponseEntity
					.created(URI.create("/api/option/category/" + optionService.addCategory(categoryDto)))
					.body(categoryDto);

		}
		
		@GetMapping("/categories")
		public ResponseEntity<?> getCategory() {
			
			return ResponseEntity.ok(optionService.getcategories());
		}
		
		@PutMapping("/category/{categoryId}")
		public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
			
			optionService.modifyCategory(categoryId, categoryDto);
			return ResponseEntity.ok(true);
			
		}
	
	
	

}
