package com.example.demo.application.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

	private Long id;
	private String userId;
	private String password;
	private String userName;
	private String email; // 필드명 변경
	private String phoneNumber;
	private String userState;
	private String userImagesURL;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	// 기본 생성자
	public UserDto() {}

	// 모든 필드를 포함하는 생성자
	public UserDto(Long id, String userId, String password, String userName, String email, String phoneNumber,
				   String userState, String userImagesURL, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userState = userState;
		this.userImagesURL = userImagesURL;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public UserDto(String userId, String password, String userName, String email, String phoneNumber, String userState, String userImagesURL) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userState = userState;
		this.userImagesURL = userImagesURL;
	}
}