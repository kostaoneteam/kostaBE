package com.example.demo.infrastructure;

import com.example.demo.application.dto.userDto.UserDetailsReadResponse;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserId(String userid); // 사용자 ID로 SiteUser 엔티티를 조회

    // carPostId에 맞는 user의 정보 파싱해서 가져옴
    @Query("SELECT new com.example.demo.application.dto.userDto.UserDetailsReadResponse(u.userName, u.phoneNumber, u.userImagesURL) " +
           "FROM User u JOIN u.carPost cp WHERE cp.id = :carPostId")
    List<UserDetailsReadResponse> findUserByCarPostId(@Param("carPostId") Long carPostId);


}
