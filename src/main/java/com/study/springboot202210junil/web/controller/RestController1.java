package com.study.springboot202210junil.web.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.study.springboot202210junil.exception.CustomTestException;
import com.study.springboot202210junil.web.dto.CmResqDto;
import com.study.springboot202210junil.web.dto.UserDto;

@RestController
public class RestController1 {
	
		
		@GetMapping("/api/test/user-dto")
		public String getUserDtoStr() {
			UserDto userDto = UserDto.builder()
					.userId(100)
					.username("abc")
					.password("1234")
					.build();

					
			return userDto.toString();
		}
			
		@GetMapping("/api/test/user-dto/obj")
		public ResponseEntity<?> getUserDtoObj(Headers headers) {
			UserDto userDto = UserDto.builder()
					.userId(100)
					.username("abc")
					.password("1234")
					.build();
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("UserDto", userDto.toString());
			
			return new ResponseEntity<>(headers, HttpStatus.OK);
			return ResponseEntity.ok()
					.headers(headers)
					.body(userDto);
	//		return new ResponseEntity<>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
	//		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto);
		}
		
		@GetMapping("api/test/user-dto/cm")
		public ResponseEntity<?> getUserDto() {
			UserDto userDto = UserDto.builder()
					.username("test")
					.password("1234")
					.build();
			
			return ResponseEntity.ok().body(new CmResqDto<>("test 유저 정보 응답", null)); 
		}
		@PostMapping("api/test/user")
		public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
			if(userDto.getUsername().isBlank()) {
				Map<String, String> errorMap = new HashMap<>();
				errorMap.put("username", "아이디를 입력하세요");
				
				throw new CustomTestException("유효성 검사 실패", errorMap);
			}
			userDto.setUserId(200);
			return ResponseEntity.created(null)
					.body(new CmResqDto<>(userDto.getUserId()+"사용자 추가 완료", userDto));
		}

		
		
	

}
