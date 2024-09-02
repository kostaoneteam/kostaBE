package com.example.demo.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@Size(min=3,max=25) // 문자열 길이
	@NotEmpty(message="사용자ID는 필수항목입니다.")
	private String userid;

	@NotEmpty(message="비밀번호는 필수항목입니다.")
	private String password1; // ‘비밀번호’

	@NotEmpty(message="비밀번호는 확인은 필수항목입니다.")
	private String password2; // ‘비밀번호 확인’

	@NotEmpty(message="이메일은 필수항목입니다.")
	@Email
	private String email;

	@NotEmpty(message="전화번호는 필수항목입니다.")
	private String phoneNumber;

	@NotEmpty(message="유저상태는 필수항목입니다.")
	private String userState;
}
