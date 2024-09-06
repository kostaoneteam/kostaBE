package com.example.demo.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	@Size(min=3,max=25) // 문자열 길이
	@NotEmpty(message="사용자ID는 필수항목입니다.")
	private String userId;

	@NotEmpty(message="비밀번호는 필수항목입니다.")
	private String password; // ‘비밀번호’

	@NotEmpty(message="이메일은 필수항목입니다.")
	@Email
	private String email;

	@NotEmpty(message="전화번호는 필수항목입니다.")
	private String phoneNumber;

	@NotEmpty(message="유저상태는 필수항목입니다.")
	private String userState;

	@NotEmpty(message="이름은 필수항목입니다.")
	private String userName;

	private String userImagesURL;

	public UserDto(String userId) {
		this.userId = userId;
	}

	public UserDto(String userId, String password, String email, String phoneNumber, String userState,
			String userName, String userImagesURL) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userState = userState;
		this.userName = userName;
		this.userImagesURL = userImagesURL;
	}


}
