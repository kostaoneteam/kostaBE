package com.example.demo.application.service;
import com.example.demo.application.dto.userDto.LoginDto;
import java.util.Optional;

import com.example.demo.DataNotFoundException;
import com.example.demo.application.dto.UserDto;
import com.example.demo.domain.User;
import com.example.demo.infrastructure.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Setter
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserDto create(String userid, String email, String password, String phoneNumber,
			String userState, String userName, String userImagesURL) {
		User user = new User();
		user.setUserId(userid);
		user.setEMail(email); // 카멜
		user.setPassword(passwordEncoder.encode(password));
		user.setPhoneNumber(phoneNumber);
		user.setUserState(userState);
		user.setUserName(userName);
		user.setUserImagesURL(userImagesURL);
//		user.setCreatedAt(createdAt);
//		user.setUpdatedAt(updatedAt);
//		user.setDeletedAt(deletedAt);

		this.userRepository.save(user);
		User savedUser = this.userRepository.save(user);
		return toDto(savedUser); // User를 UserDto로 변환하여 반환
	}

	public UserDto getUser(String userid) {
		Optional<User> user = this.userRepository.findByUserId(userid);
		if (user.isPresent()) {
			return toDto(user.get());
		} else {
			throw new DataNotFoundException("user not found");
		}
	}

	private UserDto toDto(User user) {
		return new UserDto(
				user.getUserId(),
				user.getPassword(),
				user.getUserName(),
				user.getEMail(),
				user.getPhoneNumber(),
				user.getUserState(),
				user.getUserImagesURL()
		);
	}

	public LoginDto authenticate(LoginDto loginDto) {
	    Optional<User> userOptional = userRepository.findByUserId(loginDto.getUserId());
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
	            // 인증 성공 시 LoginDto 객체를 반환
	            LoginDto resultDto = new LoginDto();
	            resultDto.setId(user.getId());
	            resultDto.setUserId(user.getUserId());
	            resultDto.setUserState(user.getUserState()); // 사용자 상태 추가

	            return resultDto;
	        }
	    }
	    return null; // 인증 실패 시 null 반환 (혹은 다른 적절한 처리를 할 수 있음)
	}

	public User findById(String userId) {
     return userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("User not found"));
 }
}

