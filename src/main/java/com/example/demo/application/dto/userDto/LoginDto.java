package com.example.demo.application.dto.userDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    @NotEmpty(message = "아이디는 필수항목입니다.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    // 기본 생성자
    public LoginDto() {}

    // 모든 필드를 포함하는 생성자
    public LoginDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}