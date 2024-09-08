package com.example.demo.application.service;
import java.util.Optional;

import com.example.demo.DataNotFoundException;
import com.example.demo.application.dto.UserDto;
import com.example.demo.domain.User;
import com.example.demo.infrastructure.UserRepository;
import lombok.Getter;
import lombok.Setter;
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

	public boolean authenticate(String userId, String rawPassword) {
		Optional<User> userOptional = userRepository.findByUserId(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			return passwordEncoder.matches(rawPassword, user.getPassword());
		}
		return false;
	}
}

