package com.example.demo.application.service;
import java.util.Optional;

import com.example.demo.application.dto.UserDto;
import com.example.demo.DataNotFoundException;
import com.example.demo.domain.User;
import com.example.demo.infrastructure.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserDto create(String userid, String email, String password, String phoneNumber, String userState, String userName,String userImagesURL) {
		User user = new User();
		user.setUserId(userid);
		user.setPassword(password);
		user.setEMail(email);
		user.setPhoneNumber(phoneNumber);
		user.setUserState(userState);
		user.setUserName(userName);
		user.setUserImagesURL(userImagesURL);

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
<<<<<<< HEAD
=======
				user.getId(),
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
				user.getUserId(),
				user.getPassword(),
				user.getUserName(),
				user.getEMail(),
				user.getPhoneNumber(),
				user.getUserState(),
<<<<<<< HEAD
				user.getUserImagesURL()
=======
				user.getUserImagesURL(),
				user.getCreatedAt(),
				user.getUpdatedAt(),
				user.getDeletedAt()
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
