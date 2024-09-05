package com.example.demo.application.service;

import com.example.demo.domain.CarPost;
import com.example.demo.domain.Likes;
import com.example.demo.domain.User;
import com.example.demo.infrastructure.CarPostRepository;
import com.example.demo.infrastructure.LikesRepository;
import com.example.demo.infrastructure.UserRepository;
import com.example.demo.application.dto.LikesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final CarPostRepository carPostRepository;
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addLike(LikesDto likesDto) {
        if (!likesRepository.existsByUserIdAndPostId(likesDto.getUserId(), likesDto.getPostId())) {
            User user = userRepository.findById(likesDto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            CarPost post = carPostRepository.findById(likesDto.getPostId())
                    .orElseThrow(() -> new IllegalArgumentException("Post not found"));

            Likes like = new Likes();
            like.setUserId(user);
            like.setPostId(post);
            likesRepository.save(like);
        }
    }

    @Transactional
    public void removeLike(LikesDto likesDto) {
        likesRepository.deleteByUserIdAndPostId(likesDto.getUserId(), likesDto.getPostId());
    }

    public int countLikes(Long postId) {
        return likesRepository.findByPostId_Id(postId).size();
    }

    public boolean isLiked(LikesDto likesDto) {
        return likesRepository.existsByUserIdAndPostId(likesDto.getUserId(), likesDto.getPostId());
    }
}

