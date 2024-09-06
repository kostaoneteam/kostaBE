package com.example.demo.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
@NoArgsConstructor
=======

import java.time.LocalDateTime;

/*
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
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

<<<<<<< HEAD
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
=======
	// 기본 생성자
	public UserDto() {
	}

	public UserDto(String userid) {
		this.userid = userid;
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
	}
}
*/

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
