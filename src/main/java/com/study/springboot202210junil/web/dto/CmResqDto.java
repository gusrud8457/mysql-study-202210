package com.study.springboot202210junil.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CmResqDto<T> {
	private String message;
	private T data;

}
