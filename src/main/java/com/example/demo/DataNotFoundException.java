package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// DB에서 특정 엔티티 또는 데이터를 찾을 수 없을 때 발생시키는 예외 클래스
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="entity not found")
public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public DataNotFoundException(String message) {
		super(message);
	}
}
