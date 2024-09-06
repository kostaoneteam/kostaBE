package com.example.demo.infrastructure;

// import com.example.demo.domain.CarPost;
import com.example.demo.domain.Likes;
// import com.example.demo.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN TRUE ELSE FALSE END FROM Likes l WHERE l.userId.id = :userId AND l.postId.id = :postId")
    boolean existsByUserIdAndPostId(@Param("userId") Long userId, @Param("postId") Long postId);

    @Modifying
    @Query("DELETE FROM Likes l WHERE l.userId.id = :userId AND l.postId.id = :postId")
    void deleteByUserIdAndPostId(@Param("userId") Long userId, @Param("postId") Long postId);

    List<Likes> findByPostId_Id(Long postId);






}