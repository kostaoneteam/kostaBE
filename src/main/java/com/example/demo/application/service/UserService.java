package com.example.demo.application.service;

import java.util.Optional;

import com.example.demo.DataNotFoundException;
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

	public User create(String userid, String email, String password, String phoneNumber, String userState, String userName) {
		User user=new User();
		user.setUserId(userid);
		user.setEMail(email); // 카멜
		user.setPassword(passwordEncoder.encode(password));
		user.setPhoneNumber(phoneNumber);
		user.setUserState(userState);
        user.setUserName(userName);
//		user.setCreatedAt(createdAt);
//		user.setUpdatedAt(updatedAt);
//		user.setDeletedAt(deletedAt);

		this.userRepository.save(user); // User 데이터를 생성하는 create 메서드를 추가
		return user;
	}
    	public User getUser(String userid) {
		Optional<User> User=this.userRepository.findByUserId(userid);
		if (User.isPresent()) {
			return User.get(); // 최종적으로 값을 끌어올려면 get() 메서드
		} else {
			throw new DataNotFoundException("user not found");
		}
	}
}
