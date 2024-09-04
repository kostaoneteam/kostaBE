package com.example.demo.infrastructure;

import java.util.Optional;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
<<<<<<< HEAD
    Optional<User> findByuserId(String userid); // 사용자 ID로 SiteUser 엔티티를 조회
=======
    //Optional<User> findByUserName(String userid); // 사용자 ID로 SiteUser 엔티티를 조회
>>>>>>> f7201aa3ba97944595125338727f3e4685fc5986
}
