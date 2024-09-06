package com.example.demo.presentation;

import com.example.demo.DataNotFoundException;
import com.example.demo.application.dto.UserDto;
/*import com.example.demo.application.dto.userDto.LoginDto;*/
import com.example.demo.application.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	/* @GetMapping("/signup") // URL이 GET으로 요청되면 회원 가입을 위한 템플릿을 렌더링
	public String signUpPage(UserDto userDto) {
		return "signup";
	} */
	/*사용자가 회원가입을 한다 -> 성공했다는 ok 사인만 주고 -> redirect 시킨다 로그인으로*/
	@PostMapping("/signup") // POST로 요청되면 회원 가입을 진행
	public ResponseEntity<UserDto> signupUser(@Valid UserDto userDto) {
		// > 사용자로부터 전달받은 데이터를 저장
		UserDto userDto1 = userService.create(userDto.getUserId(), userDto.getEmail(), userDto.getPassword(), userDto.getPhoneNumber(), userDto.getUserState(), userDto.getUserName(), userDto.getUserImagesURL());
		return ResponseEntity.ok(userDto1);

		//User 엔티티를 UserDTO로 바꾸고 그걸 리턴해야 한다.

	}
}